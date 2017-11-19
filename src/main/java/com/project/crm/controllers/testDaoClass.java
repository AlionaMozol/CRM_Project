package com.project.crm.controllers;

import com.project.crm.dao.AttributeDao;
import com.project.crm.dao.impl.AttributeDaoImpl;
import com.project.crm.dao.impl.CategoryDaoImpl;
import com.project.crm.dao.impl.UserDaoImpl;
import com.project.crm.model.Category;
import com.project.crm.model.Supercategory;
import com.project.crm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 27.10.2017.
 */
public class testDaoClass {
    public static void main(String [] args) throws SQLException {
        /*Supercategory s=new Supercategory();
        s.setTitle("Мода и стиль");

        CategoryDaoImpl c = new CategoryDaoImpl();
        List<Category> list= new ArrayList<Category>();
        list=c.getAllTopCategories();
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getTitle());
        }
        c.getAllTopCategories();*/

//        AttributeDaoImpl attributeDao = new AttributeDaoImpl();
//        List<String> list = new ArrayList<>();
//        list=attributeDao.getAttributesByCategory("PHONES");
//
//        for(int i=0; i<list.size(); i++){
//            System.out.println(list.get(i));
//        }
    }
}
