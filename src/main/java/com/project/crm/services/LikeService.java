package com.project.crm.services;

import com.project.crm.model.Product;

import java.util.List;

public interface LikeService {
    void addProductToFavorites(String productId, String username);
    void removeProductFromFavorites(Product product);
    List<Product> getFavoriteProductsByUsername(String userName);
}