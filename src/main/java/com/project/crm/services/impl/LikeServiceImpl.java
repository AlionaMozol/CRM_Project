package com.project.crm.services.impl;

import com.project.crm.dao.LikeDao;
import com.project.crm.model.Product;
import com.project.crm.model.User;
import com.project.crm.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDao likeDao;

    @Override
    @Transactional
    public void addProductToFavourites(Product product, User currentUser) {
        likeDao.addProductToFavourites(product, currentUser);
    }

    @Override
    @Transactional
    public void removeProductFromFavourites(Product product) {
        likeDao.removeProductFromFavourites(product);
    }

    @Override
    @Transactional
    public List<Product> getFavouriteProductsByUserId(String userId) {
        return likeDao.getFavouriteProductsByUsername(userId);
    }
}