package com.project.crm.services.impl;

import com.project.crm.dao.impl.SupercategoryDaoImpl;
import com.project.crm.model.Supercategory;
import java.util.List;

/**
 * Created by 1 on 07.11.2017.
 */
public class SupercategoryServiceImpl {
    private SupercategoryDaoImpl supercategoryDao = new SupercategoryDaoImpl();

    public List<Supercategory> getAllSypercategories(){
        return supercategoryDao.getAllSupercategories();

    }

}
