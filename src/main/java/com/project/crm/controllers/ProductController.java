package com.project.crm.controllers;

import com.project.crm.model.Comment;
import com.project.crm.model.Product;
import com.project.crm.model.enums.Status;
import com.project.crm.services.AttributeService;
import com.project.crm.services.CommentService;
import com.project.crm.services.ProductService;
import com.project.crm.services.*;
import com.project.crm.services.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
//@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    AttributeService attributeService;

    @Autowired
    CommentService commentService;

    @Autowired
    CategoryService categoryService;


    @RequestMapping(value= "/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable String id, Model model) {
        model.addAttribute("productid",productService.getProductById(id));
        return "/productbyid";
    }




    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String allProducts (Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("products", productService.getProductsByUsername(name));
        return "/products";
    }


    // Edition product
    @RequestMapping(value= "/product/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable String id, Model model) {
        model.addAttribute("IDProduct", productService.getProductById(id));
        model.addAttribute("ID", id);
        return "/edit_product";
    }

    @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.POST)
    public String editProduct(@PathVariable String id, @ModelAttribute("EditProduct") Product product) {
        productService.editProduct(id, product);
        return "redirect:/products";
    }
    /////////////////////////////////

    @RequestMapping(value = "/not_moderated", method = RequestMethod.GET)
    public String notModeratedProducts(Model model){
        //is expected
        //model.addAttribute("products", productService.getProductByStatus(Status.MODERATION));
        model.addAttribute("products", productService.getAllProducts());
        return "/product_moderation";

    }

    @RequestMapping(value = "/new_product", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("topCategories", categoryService.getAllTopCategories());
        return "new_product";
    }

    @ModelAttribute("product")
    public Product newProduct() {
        Product product = new Product();
        Map<String,String> map = new HashMap<>();
        map.put("COST","");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        product.setOwner(name);

        product.setAttributesAndValues(map);
        return product;
    }

    @RequestMapping(value = "/new-product/add", method = RequestMethod.POST)
    public String addProduct(HttpServletRequest request) {
        Product product = new Product();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Map<String, String[]> myMap = request.getParameterMap();

        product.setOwner(name);
        product.setSuperCategory(myMap.get("superCategory")[0]);
        product.setCategory(myMap.get("category")[0]);
        product.setCost(myMap.get("COST")[0]);

        List<String> attributes = attributeService.getAttributesByCategory(myMap.get("category")[0]);
        Map<String, String> productAttributes = new HashMap<>();
        for(int i = 0; i < attributes.size(); i++){
            productAttributes.put(attributes.get(i), myMap.get(attributes.get(i))[0]);
        }

        product.setAttributesAndValues(productAttributes);
        productService.addProduct(product);
        return "redirect:/products";
    }

    @RequestMapping(value = "/attributes", method = RequestMethod.GET)
    @ResponseBody
    public List getAttributes(@RequestParam String subCategory){
        return attributeService.getAttributesByCategory(subCategory);
    }

//    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
//    public String getPayment(@PathVariable("id") long id, Model model) {
//        model.addAttribute("payment", productService.getProductById(id));
//        return "/payment.jsp";
//    }
}
