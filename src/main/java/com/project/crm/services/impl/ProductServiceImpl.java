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

@Transactional
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

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
}
