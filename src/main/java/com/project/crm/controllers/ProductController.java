package com.project.crm.controllers;

import com.project.crm.model.Product;
import com.project.crm.services.AttributeService;
import com.project.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    AttributeService attributeService;



    @RequestMapping(value= "/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable String id, Model model) {
        model.addAttribute("productid",productService.getProductById(id));
        return "/productbyid";
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String allProducts (Model model){
        model.addAttribute("products", productService.getAllProducts());
        //return new ModelAndView("product", "command", new Product());
        return "/products";
    }

    @RequestMapping(value = "/not_moderated", method = RequestMethod.GET)
    public String notModeratedProducts(Model model){
        //temporarily
        model.addAttribute("products", productService.getAllProducts());

        return "/product_moderation";
    }

    @RequestMapping(value = "/new_product", method = RequestMethod.GET)
    public String addProduct() {
        return "new_product";
    }

    @ModelAttribute("product")
    public Product newProduct() {
        Product product = new Product();
        Map<String,String> map = new HashMap<>();
        List<String> attributes = attributeService.getAttributesByCategory("PHONES");
        map.put("COST","10");
        map.put("OWNER","IvanTkachev");
        for (String attribute : attributes) map.put(attribute, "");

        product.setAttributesAndValues(map);
        product.setSuperCategory("Technics");
        product.setCategory("PHONES");
        return product;
    }
    @RequestMapping(value = "/new-product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

//    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
//    public String getPayment(@PathVariable("id") long id, Model model) {
//        model.addAttribute("payment", productService.getProductById(id));
//        return "/payment.jsp";
//    }
}
