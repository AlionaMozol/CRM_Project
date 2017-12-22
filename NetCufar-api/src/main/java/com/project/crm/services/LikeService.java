package com.project.crm.services;

import com.project.crm.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeService {
    void addProductToFavorites(String productId, String username);
    void removeProductFromFavorites(String productId, String username);
    List<Product> getFavoriteProductsByUsername(String userName);
}