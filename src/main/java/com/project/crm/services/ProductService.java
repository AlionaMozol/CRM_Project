package com.project.crm.services;

import com.project.crm.model.Product;
import com.project.crm.model.enums.ProductStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ProductService {

    void addProduct(Product product);
    void editProduct(String id, Product product);
    Product getProductById(String id);
    List<Product> getProductsByKeyWords(String keyWords);
    List<Product> getProductsByUsername(String username);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsBySupercategory(String supercategory);
    List<Product> getProductsAfterDate(Date date);
    List<Product> getProductsByStatus(ProductStatus status);
    List<Product> getAllProducts();
    void deleteProductById(String id);
    void changeProductStatus(String id, ProductStatus status);
}
