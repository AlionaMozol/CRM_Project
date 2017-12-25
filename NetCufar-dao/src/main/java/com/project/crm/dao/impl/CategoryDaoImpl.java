package com.project.crm.dao.impl;

import com.project.crm.dao.CategoryDao;
import com.project.crm.dao.DAO;
import com.project.crm.model.Category;
import com.project.crm.services.SqlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 06.11.2017.
 */
@Component
public class CategoryDaoImpl extends DAO implements CategoryDao {

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public List<Category> getCategoriesByTopCategory(String topCategory) {
        Connection connection = poolInst.getConnection();
        List<Category> topCategotiesList = new ArrayList<Category>();
//        String object_typeID="";
        try  {
//            PreparedStatement statement = connection.prepareStatement(sql.getProperty(SqlService.SQL_SELECT_BY_OBJECT_TYPE));
//            statement.setString(1, "CATEGORY");
//            ResultSet rs = statement.executeQuery();
//            if(rs.next()){
//                object_typeID=rs.getString(1);
//            }
            PreparedStatement statement = connection.prepareStatement(sql.getProperty(SqlService.SQL_SELECT_OBJECT_ID_BY_VALUE));
            statement.setString(1, topCategory);
            ResultSet rs = statement.executeQuery();
            ResultSet resultSet=null;
            while(rs.next()){
                statement = connection.prepareStatement(sql.getProperty(SqlService.SQL_GET_PRODUCT_BY_LIKE_ID));
                statement.setString(1, rs.getString(1));
                statement.setString(2, categoryAttrID.getProperty("NAME"));
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Category category = new Category();
                    category.setTitle(resultSet.getString(1));
                    Category supercategoty = new Category();
                    supercategoty.setTitle(topCategory);
                    supercategoty.setTop(true);
                    category.setSupercategory(supercategoty);
                    topCategotiesList.add(category);
                }
            }
            statement.close();
            rs.close();
            resultSet.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return topCategotiesList;
    }


    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public List<Category> getAllTopCategories() {
        Connection connection = poolInst.getConnection();
        List<Category> topCategotyList = new ArrayList<Category>();
//        String object_typeID="";
        try  {
//            PreparedStatement statement = connection.prepareStatement(sql.getProperty(SqlService.SQL_SELECT_BY_OBJECT_TYPE));
//            statement.setString(1, "CATEGORY");
//            ResultSet rs = statement.executeQuery();
//            if(rs.next()){
//                object_typeID=rs.getString(1);
//            }
            PreparedStatement statement = connection.prepareStatement(sql.getProperty(SqlService.SQL_GET_ALL_SUPERCATEGORIES));
            statement.setString(1, categoryAttrID.getProperty("SUPERCATEGORY"));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category category=new Category();
                category.setTitle(rs.getString(1));
                category.setTop(true);
                topCategotyList.add(category);
            }
            statement.close();
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return topCategotyList;
    }

    /*public static void main(String [] args) throws SQLException {
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        List<Category> topCategotiesList =categoryDao.getAllTopCategories();
        Category category = new Category();
       for (int i=0; i<topCategotiesList.size(); i++){

                System.out.println(topCategotiesList.get(i).getTitle());

        }
        List<Category> CategotiesList =categoryDao.getCategoriesByTopCategory("Fashion");

        for (int i=0; i<CategotiesList.size(); i++){

            System.out.println(CategotiesList.get(i).getTitle());

        }

        /*for (int i=0; i<topCategotiesList.size(); i++){
            if (topCategotiesList.get(i).getSupercategory()!=null)
                System.out.println(topCategotiesList.get(i).getTitle()+" "+topCategotiesList.get(i).getSupercategory().getTitle()+ " "+ topCategotiesList.get(i).isTop());
            else{
                System.out.println(topCategotiesList.get(i).getTitle()+topCategotiesList.get(i).isTop());

            }
        }



    }*/


}

