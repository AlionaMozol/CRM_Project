package com.project.crm.services.impl;

import com.project.crm.dao.impl.SupercategoryDaoImpl;
import com.project.crm.model.Supercategory;
import java.util.List;

/**
 * Created by 1 on 07.11.2017.
 */
public class SupercategoryServiceImpl {


    private static	SupercategoryServiceImpl instance;
    private static SupercategoryDaoImpl dao;

    public static SupercategoryServiceImpl getInstance() {
        if (instance == null) {
            instance = new SupercategoryServiceImpl();
            dao = new SupercategoryDaoImpl();
        }
        return instance;
    }

    public List<Supercategory> getAllSypercategories(){
        return dao.getAllSupercategories();

    }

}
