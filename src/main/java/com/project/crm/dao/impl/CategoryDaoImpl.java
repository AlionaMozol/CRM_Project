package com.project.crm.dao.impl;

import com.project.crm.dao.CategoryDao;
import com.project.crm.model.Category;

import java.sql.*;
import java.util.*;

import com.project.crm.dao.DAO;
import com.project.crm.services.SqlService;
import org.springframework.stereotype.Component;

/**
 * Created by 1 on 06.11.2017.
 */
@Component
public class CategoryDaoImpl extends DAO implements CategoryDao {

    @Override
    public List<Category> getCategoriesByTopCategory(Category topCategory) {
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        List<Category> allCategotyList = new ArrayList<Category>();
        List<Category> resultCategotyList = new ArrayList<Category>();
        allCategotyList=categoryDao.getAllCategories();
        for(Category category : allCategotyList){
            if(category.getSupercategory()!=null && category.getSupercategory().getTitle().equals(topCategory.getTitle())){
                resultCategotyList.add(category);
            }
        }
        return resultCategotyList;
    }

    @Override
    public List<Category> getAllCategories() {
        Connection connection = poolInst.getConnection();
        List<Category> topCategotiesList = new ArrayList<Category>();
        String object_typeID="";
        try  {
            PreparedStatement statement = connection.prepareStatement(sql.getProperty(SqlService.SQL_SELECT_BY_OBJECT_TYPE));
            statement.setString(1, "CATEGORY");
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                object_typeID=rs.getString(1);
            }
            statement = connection.prepareStatement(sql.getProperty(SqlService.SQL_GET_ALL_CATEGORIES));
                    statement.setString(1, object_typeID);
            rs = statement.executeQuery();
            String prevObject_typeID="";
            Category prevCategory = new Category();
            while (rs.next()) {
                Category category = new Category();
                category.setTitle(rs.getString(1));
                if(rs.getString(2).equals("SUPERCATEGORY")){
                    category.setTop(true);
                }
                if(rs.getString(2).equals("NAME")){
                    category.setTop(false);
                    if(rs.getString(3).equals(prevObject_typeID)){
                        category.setSupercategory(prevCategory);
                   }
                }
                prevObject_typeID=rs.getString(3);
                prevCategory=category;
                topCategotiesList.add(category);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return topCategotiesList;
    }

    @Override
    public List<Category> getAllTopCategories() {
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        List<Category> allCategotyList = new ArrayList<Category>();
        List<Category> allTopCategotyList = new ArrayList<Category>();
        LinkedHashSet <Category> categoryLinkedHashSet = new LinkedHashSet<>();
        allCategotyList=categoryDao.getAllCategories();
        for(Category category : allCategotyList){
            if(category.isTop()){
                if(categoryLinkedHashSet.add(category)){
                    allTopCategotyList.add(category);
                }
            }
        }
        return allTopCategotyList;
    }

    /*public static void main(String [] args) throws SQLException {
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        List<Category> topCategotiesList = new ArrayList<Category>();
        topCategotiesList=categoryDao.getAllCategories();
        Category category = new Category();
        category.setTitle("Fashion");
        topCategotiesList=categoryDao.getCategoriesByTopCategory(category);
       for (int i=0; i<topCategotiesList.size(); i++){

                System.out.println(topCategotiesList.get(i).getTitle());

        }

        for (int i=0; i<topCategotiesList.size(); i++){
            if (topCategotiesList.get(i).getSupercategory()!=null)
                System.out.println(topCategotiesList.get(i).getTitle()+" "+topCategotiesList.get(i).getSupercategory().getTitle()+ " "+ topCategotiesList.get(i).isTop());
            else{
                System.out.println(topCategotiesList.get(i).getTitle()+topCategotiesList.get(i).isTop());

            }
        }



    }*/


}

