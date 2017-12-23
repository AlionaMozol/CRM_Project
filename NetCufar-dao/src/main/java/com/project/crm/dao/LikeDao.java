package com.project.crm.dao;

import com.project.crm.model.Product;

import java.util.List;

/**
 * Basic Data Access Object interface.
 * Provide operations with favorite{@link Product}.
 */
public interface LikeDao {
    void addProductToFavorites(String productId, String username);

    void removeProductFromFavorites(String productId, String username);

    Product getProductByLikeId(String likeId);

    List<Product> getFavoriteProductsByUsername(String userName);
}