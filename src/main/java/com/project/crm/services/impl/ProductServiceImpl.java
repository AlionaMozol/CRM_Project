package com.project.crm.services.impl;

import com.project.crm.dao.ProductDao;
import com.project.crm.model.Product;
import com.project.crm.model.enums.ProductStatus;
import com.project.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Transactional
    @Override
    public List<Product> getProductsByUsername(String username) {
        return productDao.getProductsByUsername(username);
    }

    @Transactional
    @Override
    public void editProduct(String id, Product product) {productDao.editProduct(id, product);  }

    @Transactional
    @Override
    public Product getProductById(String id) {
        return productDao.getProductById(id);
    }

    @Transactional
    @Override
    public List<Product> getProductsByKeyWords(String keyWords) {
        return productDao.getProductsByKeyWords(keyWords);
    }

    @Transactional
    @Override
    public List<Product> getProductsByCategory(String category) {
        return productDao.getProductsByCategory(category);
    }

    @Transactional
    @Override
    public List<Product> getProductsBySupercategory(String supercategory) {
        return productDao.getProductsBySupercategory(supercategory);
    }

    @Transactional
    @Override
    public List<Product> getProductsAfterDate(Date date) {
        return productDao.getProductsAfterDate(date);
    }

    @Transactional
    @Override
    public List<Product> getProductsByStatus(ProductStatus status) {
        return productDao.getProductsByStatus(status);
    }

    @Transactional
    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Transactional
    @Override
    public void deleteProductById(String id) {
        productDao.deleteProductById(id);
    }
}
