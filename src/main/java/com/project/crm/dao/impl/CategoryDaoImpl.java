package com.project.crm.dao.impl;

import com.project.crm.dao.CategoryDao;
import com.project.crm.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.project.crm.dao.DAO;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;
import java.util.UUID;
/**
 * Created by 1 on 06.11.2017.
 */
@Component
public class CategoryDaoImpl extends DAO implements CategoryDao {

    @Override
    public List<Category> getCategoriesByTopCategory(Category topCategory) {
        Connection connection = poolInst.getConnection();
        List<Category> categotyList = new ArrayList<Category>();
        try  {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT Value FROM spring_security_app.object_type WHERE Supercategory = ?");
            statement.setString(1,topCategory.getTitle());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setTitle(rs.getString("Value"));
                category.setSupercategory(topCategory);
                categotyList.add(category);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return categotyList;
    }


    @Override
    public List<Category> getAllTopCategories() {
        Connection connection = poolInst.getConnection();
        List<Category> topCategotiesList = new ArrayList<Category>();
        try  {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT DISTINCT Supercategory FROM spring_security_app.object_type WHERE Supercategory IS NOT NULL");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category topCategory = new Category();
                topCategory.setTitle(rs.getString("supercategory"));
                topCategory.setTop(true);
                topCategotiesList.add(topCategory);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return topCategotiesList;
    }


}
