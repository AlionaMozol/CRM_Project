package com.project.crm.dao;

import com.project.crm.model.Product;
import com.project.crm.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LikeDao {
    void addProductToFavourites(Product product, User currentUser);
    void removeProductFromFavourites(Product product);
    Product getProductByLikeId(String likeId);
    List<Product> getFavouriteProductsByUsername(String userName);
}