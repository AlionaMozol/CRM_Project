package com.project.crm.services.impl;

import com.project.crm.dao.ProductDao;
import com.project.crm.model.Product;
import com.project.crm.model.enums.Status;
import com.project.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public void addProduct(Product product) {
         productDao.addProduct(product);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    public List<Product> getProductsByTitle(String title) {
        return productDao.getProductsByTitle(title);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productDao.getProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsAfterDate(Date date) {
        return productDao.getProductsAfterDate(date);
    }

    @Override
    public List<Product> getProductsBetween2Prices(int priceAfter, int priceBefore) {
        return productDao.getProductsBetween2Prices(priceAfter, priceBefore);
    }

    @Override
    public List<Product> getProductByStatus(Status status) {
        return productDao.getProductByStatus(status);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public void deleteProductById(int id) {
        productDao.deleteProductById(id);
    }
}
