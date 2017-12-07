package com.project.crm.dao;

import com.project.crm.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LikeDao {
    void addProductToFavorites(String productId, String username);
    void removeProductFromFavorites(Product product);
    Product getProductByLikeId(String likeId);
    List<Product> getFavoriteProductsByUsername(String userName);
}