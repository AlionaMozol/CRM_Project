package com.project.crm.controllers;

import com.project.crm.model.Product;
import com.project.crm.model.enums.ProductStatus;
import com.project.crm.services.*;
import com.project.crm.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Controller for {@link com.project.crm.model.Product}
 */
@Controller
//@RequestMapping("/product")
public class ProductController {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    AttributeService attributeService;

    @Autowired
    CommentService commentService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductValidator productValidator;

    @Autowired
    LikeService likeService;

    @Autowired
    ProfileService profileService;

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String getSearch(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        //products by key words
        String keyWord;
        String resultMSG;
        if (RequestContextUtils.getLocale(request).toString().equals("ru")) {
            resultMSG = "ВВЕДИТЕ ЧТО-НИБУДЬ В СТРОКУ ПОИСКА :)";
        } else {
            resultMSG = "YOU DID'NT ENTER WHAT YOU WANT :)";
        }
        if (request.getParameter("q") != null) {
            keyWord = new String(request.getParameter("q").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            if (!keyWord.replaceAll("\\s", "").equals("")) {
                List<Product> productsByKeyWords = productService.getProductsByKeyWords(keyWord);
                List <Product> approvedProducts = new ArrayList<>();
                for(Product product : productsByKeyWords) {
                    if (product.getProductStatus() == ProductStatus.APPROVED) {
                        approvedProducts.add(product);
                    }
                }
                if (approvedProducts.size() == 0) {
                    if (RequestContextUtils.getLocale(request).toString().equals("ru")) {
                        resultMSG = "НИЧЕГО НЕ НАЙДЕНО ПО ЗАПРОСУ '" + keyWord + "'";
                    } else {
                        resultMSG = "NOTHING FOUND FOR '" + keyWord + "'";
                    }
                } else {
                    if (RequestContextUtils.getLocale(request).toString().equals("ru")) {
                        resultMSG = "РЕЗУЛЬТАТЫ ПО ЗАПРОСУ '" + keyWord + "'";
                    } else {
                        resultMSG = "RESULTS FOR '" + keyWord + "'";
                    }
                }
                model.addAttribute("products", approvedProducts);
            }
        }
        model.addAttribute("result_message", resultMSG);
        //liked products
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("favorite_products", likeService.getFavoriteProductsByUsername(name));
        //locale
        Locale locale = RequestContextUtils.getLocale(request);
        ResourceBundle bundle = ResourceBundle.getBundle("locales.messages", locale);
        model.addAttribute("keys", bundle.getKeys());
        return "catalog";
    }


    @RequestMapping(value = "/catalog/{username}", method = RequestMethod.GET)
    public String getCurrentUserProducts(@PathVariable String username, Model model, HttpServletRequest request) {
        List<Product> products = productService.getProductsByUsername(username);
        String result_msg;
        if (RequestContextUtils.getLocale(request).toString().equals("ru")) {
            result_msg = "ТАКОГО ПОЛЬЗОВАТЕЛЯ НЕ СУЩЕСТВУЕТ";
        } else {
            result_msg = "USER NOT FOUND";
        }

        if (userService.findByUsername(username) != null) {
            if (RequestContextUtils.getLocale(request).toString().equals("ru")) {
                result_msg = "Товары пользователя: " + username + ". Количество : " + products.size();
            }
            if (RequestContextUtils.getLocale(request).toString().equals("en")) {
                result_msg = "Products of user: " + username + ". Amount : " + products.size();
            }
        }
        model.addAttribute("result_message", result_msg);
        model.addAttribute("products", products);
        return "/catalog";
    }


    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable String id, Model model) {
        Product product = productService.getProductById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("favorite_products", likeService.getFavoriteProductsByUsername(name));
        if (product == null) {
            return "/error_page404";
        } else {
            model.addAttribute("productid", product);
            return "/productbyid";
        }
    }


    @RequestMapping(value = "/not_moderated_accept", method = RequestMethod.GET)
    public String acceptProduct(@RequestParam String productId) {
        productService.changeProductStatus(productId, ProductStatus.APPROVED);
        return "redirect:/product_moderation";
    }


    @RequestMapping(value = "/not_moderated_deny", method = RequestMethod.GET)
    public String denyProduct(@RequestParam String productId) {
        productService.changeProductStatus(productId, ProductStatus.CANCELED);
        return "/product_moderation";
    }


    @RequestMapping(value = "/my_products", method = RequestMethod.GET)
    public String allProducts(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("products", productService.getProductsByUsername(name));
        return "/my_products";
    }


    // Edition product
    @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable String id, Model model) {
        Product product = productService.getProductById(id);
        String[] cost = product.getCost().split(" ");
        model.addAttribute("CURRENCY", cost[1]);
        product.setCost(cost[0]);
        model.addAttribute("IDProduct", product);
        model.addAttribute("ID", id);
        return "/edit_product";
    }


    @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("EditProduct") Product product, BindingResult bindingResult,
                              @RequestParam("COST_TYPE") String currency, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        product.setCost(product.getCost() + " " + currency);
        product.setSuperCategory("SuperCategory");
        product.setCategory("Category");
//        productValidator.validate(product,bindingResult);
//        if(bindingResult.hasErrors()){
//            return "redirect:/product/edit/{id}";
//        }
        productService.editProduct(product, multipartFile);
        return "redirect:/my_products";
    }


    @RequestMapping(value = "/not_moderated", method = RequestMethod.GET)
    public String notModeratedProducts(Model model, HttpServletRequest request) {
        //почему-то все возвращается в 2 экземплярах - запрос в бд неправильный?
        //model.addAttribute("productCategory", categoryService.getAllTopCategories());
        List notModProd = productService.getProductsByStatus(ProductStatus.MODERATION);
        model.addAttribute("nmod_products", notModProd);
        //model.addAttribute("nmod_products", productService.getAllProducts());
        String resultMSG;
        if (notModProd.size() != 0) {
            if (RequestContextUtils.getLocale(request).toString().equals("ru")) {
                resultMSG = "ПРОДУКТЫ ДЛЯ МОДЕРАЦИИ:";
            } else {
                resultMSG = "NOT MODERATED PRODUCTS:";
            }
        } else {
            if (RequestContextUtils.getLocale(request).toString().equals("ru")) {
                resultMSG = "ВСЕ ПРОДУКТЫ ПРОШЛИ МОДЕРАЦИЮ.";
            } else {
                resultMSG = "ALL PRODUCTS ARE MODERATED.";
            }
        }
        model.addAttribute("result_message", resultMSG);
        return "/product_moderation";

    }


    @RequestMapping(value = "/new_product", method = RequestMethod.GET)
    public String addProduct(Model model, HttpServletRequest request) {
        Locale locale = RequestContextUtils.getLocale(request);

        ResourceBundle bundle = ResourceBundle.getBundle("locales.messages", locale);
        model.addAttribute("keys", bundle.getKeys());
        model.addAttribute("topCategories", categoryService.getAllTopCategories());
        return "new_product";
    }


    @RequestMapping(value = "/new-product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product, BindingResult bindingResult, HttpServletRequest request,
                             @RequestParam("file") MultipartFile multipartFile) throws IOException {
        product = productService.getProductByHttpServletRequestAndPhoto(request, multipartFile);
        productValidator.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/new_product";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        String userStatus = profileService.getUserByUsername(name).getStatus();
        if (userStatus.equals("UNBLOCKED")) {
            productService.addProduct(product);
        } else {
            return "/errorStatus";
        }
        return "redirect:/my_products";
    }


    @RequestMapping(value = "/attributes", method = RequestMethod.GET)
    @ResponseBody
    public List getAttributes(@RequestParam String subCategory) {
        return attributeService.getAttributesByCategory(subCategory);
    }


    @RequestMapping(value = "/productSearch", method = RequestMethod.GET)
    @ResponseBody
    public List getProductsBySubString(@RequestParam String subString) throws UnsupportedEncodingException {
        String checkIfEmptyBuf = java.net.URLDecoder.decode(subString, "UTF-8");
        if (!(checkIfEmptyBuf.replaceAll("\\s", "")).equals("")) {
            List <Product> productsByKeyWords = productService.getProductsByKeyWords(checkIfEmptyBuf);
            List <Product> approvedProducts = new ArrayList<>();
            for(Product product : productsByKeyWords) {
                if (product.getProductStatus() == ProductStatus.APPROVED) {
                    approvedProducts.add(product);
                }
            }
            return approvedProducts;
        } else {
            return new ArrayList();
        }
    }
}
