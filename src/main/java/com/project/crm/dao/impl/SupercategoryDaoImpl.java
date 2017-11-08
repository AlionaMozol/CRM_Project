package com.project.crm.dao.impl;

import com.project.crm.dao.SupercategoryDao;
import com.project.crm.model.Supercategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.project.crm.dao.DAO;

/**
 * Created by 1 on 02.11.2017.
 */

public class SupercategoryDaoImpl extends DAO implements SupercategoryDao {


    @Override
    public List<Supercategory> getAllSupercategories() {
        Connection connection = poolInst.getConnection();

        List<Supercategory> supercategotyList = new ArrayList<Supercategory>();

        try  {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT DISTINCT supercategory FROM spring_security_app.object_type WHERE supercategory IS NOT NULL");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Supercategory supercategory = new Supercategory();
                supercategory.setTitle(rs.getString("supercategory"));
                supercategotyList.add(supercategory);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return supercategotyList;
    }
}
