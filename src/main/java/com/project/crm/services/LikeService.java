package com.project.crm.services;

import com.project.crm.model.Product;
import com.project.crm.model.User;

import java.util.List;

public interface LikeService {
    void addProductToFavourites(Product product, User currentUser);
    void removeProductFromFavourites(Product product);
    List<Product> getFavouriteProductsByUserId(String userId);
}