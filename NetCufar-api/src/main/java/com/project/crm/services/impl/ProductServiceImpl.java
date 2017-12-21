package com.project.crm.services.impl;

import com.project.crm.dao.AttributeDao;
import com.project.crm.dao.ProductDao;
import com.project.crm.model.Product;
import com.project.crm.model.enums.ProductStatus;
import com.project.crm.services.ProductService;
import com.project.crm.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.crm.services.GoogleDriveAPI.addPohotoToDrive;

@Transactional
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    AttributeDao attributeDao;

    @Autowired
    ProductValidator productValidator;

    @Override
    public Product getProductByHttpServletRequestAndPhoto(HttpServletRequest request, MultipartFile photo){
        Product product = new Product();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Map<String, String[]> parameterMap = request.getParameterMap();

        product.setOwner(name);
        product.setSuperCategory(parameterMap.get("superCategory")[0]);
        product.setCategory(parameterMap.get("category")[0]);
        product.setCost(parameterMap.get("cost")[0].trim() + " " + parameterMap.get("COST_TYPE")[0]);
        product.setTitle(parameterMap.get("title")[0].trim());
        if(parameterMap.get("description")[0] != null)
            product.setDescription(parameterMap.get("description")[0].trim());
        if(photo.isEmpty())
            product.setPhoto("-1");
        else
            try {
                product.setPhoto(addPohotoToDrive(photo));
            } catch (IOException e) {
                e.printStackTrace();
            }

        List<String> attributes = attributeDao.getAttributesByCategory(parameterMap.get("category")[0]);

        Map<String, String> productAttributes = new HashMap<>();
        for (String attribute : attributes) {
            productAttributes.put(attribute, parameterMap.get(attribute)[0].trim());
        }

        product.setAttributesAndValues(productAttributes);
        return product;
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public List<Product> getProductsByUsername(String username) {
        return productDao.getProductsByUsername(username);
    }


    @Override
    public void editProduct(String id, Product product) {productDao.editProduct(id, product);  }

    @Override
    public Product getProductById(String id) {
        return productDao.getProductById(id);
    }

    @Override
    public List<Product> getProductsByKeyWords(String keyWords) {
        return productDao.getProductsByKeyWords(keyWords);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productDao.getProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsBySupercategory(String supercategory) {
        return productDao.getProductsBySupercategory(supercategory);
    }

    @Override
    public List<Product> getProductsAfterDate(Date date) {
        return productDao.getProductsAfterDate(date);
    }

    @Override
    public List<Product> getProductsByStatus(ProductStatus status) {
        return productDao.getProductsByStatus(status);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public void deleteProductById(String id) {
        productDao.deleteProductById(id);
    }

    @Override
    public void changeProductStatus(String id, ProductStatus status) {
        productDao.changeProductStatus(id, status);
    }
}
