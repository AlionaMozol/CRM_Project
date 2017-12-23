package com.project.crm.services;

import com.project.crm.model.Product;

import java.util.List;

/**
 * Service class for favorites {@link com.project.crm.model.Product}
 */
public interface LikeService {
    void addProductToFavorites(String productId, String username);

    void removeProductFromFavorites(String productId, String username);

    List<Product> getFavoriteProductsByUsername(String userName);
}