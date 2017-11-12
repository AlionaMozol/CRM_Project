package com.project.crm.controllers;

import com.project.crm.model.Category;
import com.project.crm.model.Product;
import com.project.crm.model.Supercategory;
import com.project.crm.services.ProductService;
import com.project.crm.services.impl.SupercategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(value="product")
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {

        List<Supercategory> supercategoryList = null;
        supercategoryList = SupercategoryServiceImpl.getInstance().getAllSypercategories();
        model.addAttribute("product", supercategoryList);
        return "/welcome";
    }

   /* @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable int id, Model model) {
        model.addAttribute(productService.getProductById(id));
        return "products";
    }*/


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String allProducts (Model model){
        model.addAttribute("products", productService.getAllProducts());
        //return new ModelAndView("product", "command", new Product());
        return "/products";
    }

    @RequestMapping(value = "/new_product", method = RequestMethod.GET)
    public String addProduct() {
        return "new_product";
    }

    @ModelAttribute("product")
    public Product newProduct() {
        Product product = new Product();
        Map<String,String> map = new HashMap<>();
        map.put("Cost", "25");
        product.setAttributesAndValues(map);
        product.setSuperCategory("Техника");
        product.setCategory("Телефоны");
        return product;
    }
    @RequestMapping(value = "/new-product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "products";
    }

//    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
//    public String getPayment(@PathVariable("id") long id, Model model) {
//        model.addAttribute("payment", productService.getProductById(id));
//        return "/payment.jsp";
//    }
}
