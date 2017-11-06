package com.project.crm.dao.impl;

import com.project.crm.dao.CategoryDao;
import com.project.crm.model.Category;
import com.project.crm.model.Supercategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.crm.dao.DAO;

/**
 * Created by 1 on 06.11.2017.
 */
public class CategoryDaoImpl extends DAO implements CategoryDao {
    @Override
    public List<Category> getCategoriesBySupercategory(Supercategory supercategory) {
        Connection connection = poolInst.getConnection();
        List<Category> categotyList = new ArrayList<Category>();
        try  {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT Value FROM spring_security_app.object_type WHERE Supercategory = ?");
            statement.setString(1,supercategory.getTitle());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setTitle(rs.getString("Value"));
                categotyList.add(category);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return categotyList;
    }

    @Override
    public List<Category> getALLCategories() {
        Connection connection = poolInst.getConnection();
        List<Category> categotyList = new ArrayList<Category>();
        try  {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT Value FROM spring_security_app.object_type");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setTitle(rs.getString("Value"));
                categotyList.add(category);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return categotyList;
    }
}
