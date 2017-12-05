package com.project.crm.dao;

import com.project.crm.model.Product;
import com.project.crm.model.User;
import com.project.crm.model.enums.ProductStatus;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public interface ProductDao {
    void addProduct(Product product);
    List<Product> getProductsByUsername(String username);
    void editProduct(String id, Product product);
    Product getProductById(String id);
    List<Product> getProductsByTitle(String title);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsAfterDate(Date date);
    List<Product> getProductByStatus(ProductStatus status);
    List<Product> getAllProducts();
    void deleteProductById(String id);
}
