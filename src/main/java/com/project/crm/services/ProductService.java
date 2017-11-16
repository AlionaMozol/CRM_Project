package com.project.crm.services;

import com.project.crm.model.Product;
import com.project.crm.model.enums.Status;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ProductService {

    void addProduct(Product product);
    Product getProductById(String id);
    List<Product> getProductsByTitle(String title);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsAfterDate(Date date);
    List<Product> getProductsBetween2Prices(int priceAfter, int priceBefore);
    List<Product> getProductByStatus(Status status);
    List<Product> getAllProducts();
    void deleteProductById(String id);
}
