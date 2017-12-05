package com.project.crm.services;

import com.project.crm.model.Product;
import com.project.crm.model.User;
import com.project.crm.model.enums.ProductStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public interface ProductService {

    void addProduct(Product product);
    void editProduct(String id, Product product);
    Product getProductById(String id);
    List<Product> getProductsByTitle(String title);
    List<Product> getProductsByUsername(String username);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsAfterDate(Date date);
    List<Product> getProductByStatus(ProductStatus status);
    List<Product> getAllProducts();
    void deleteProductById(String id);
}
