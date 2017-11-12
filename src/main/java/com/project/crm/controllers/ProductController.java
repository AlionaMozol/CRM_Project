package com.project.crm.controllers;

import com.project.crm.model.Product;
import com.project.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;



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
