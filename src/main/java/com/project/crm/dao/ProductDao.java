package com.project.crm.dao;

import com.project.crm.model.Product;
import com.project.crm.model.enums.Status;

import java.util.Date;
import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    Product getProductById(int id);
    List<Product> getProductsByTitle(String title);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsAfterDate(Date date);
    List<Product> getProductsBetween2Prices(int priceAfter, int priceBefore);
    List<Product> getProductByStatus(Status status);
    List<Product> getAllProducts();
    boolean deleteProductById(int id);
}
