package com.project.crm.dao.impl;


import com.project.crm.dao.DAO;
import com.project.crm.dao.ProductDao;
import com.project.crm.model.Product;
import com.project.crm.model.enums.Status;
import com.project.crm.services.SqlService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class ProductDaoImpl extends DAO implements ProductDao {

    @Override
    public void addProduct(Product product) {
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
    }

    @Override
    public Product getProductById(int id) {
        Connection connection = poolInst.getConnection();
        Product currentProduct = new Product();
        try {
            int i = 0;
            int g = 0;
            int currentObjectTypeId = 0;
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCT_BY_ID));
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                currentObjectTypeId = resultSet.getInt(2);
            }

            statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCT_TYPE_BY_ID));
            statement.setInt(1, currentObjectTypeId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                /*System.out.println("Record: "
                        + resultSet.getInt(1) + " "
                        + resultSet.getString(2) + " "  //Категория
                        + resultSet.getString(3));      //это суперкатегория - их потом сетаем в currentProduct*/
            }
            /*statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_ATTRIBUTE_COST_BY_OBJECT_TYPE_ID));
            statement.setInt(1, g);
            resultSet = statement.executeQuery();
            int h = 0;
            while(resultSet.next()) {
                h = resultSet.getInt(1);
                System.out.println(resultSet.getInt(1)+" - AttrId");
            }
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_COST_BY_ATTRIBUTE_ID_AND_OBJECT_ID));
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }

        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public List<Product> getProductsByTitle(String title) {  //Пока нет в базе
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCTS_BY_CATEGORY));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public List<Product> getProductsAfterDate(Date date) {   //Пока нет в базе
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public List<Product> getProductsBetween2Prices(int priceAfter, int priceBefore) {
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCTS_BETWEEN_2_PRICES));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public List<Product> getProductByStatus(Status status) {  // Пока нет в базе
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_ALL_PRODUCTS));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public boolean deleteProductById(int id) {
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
        return false;
    }

    /*    public static void main(String[] args) throws ClassNotFoundException {
          long l = 1;
          ProductDaoImpl d = new ProductDaoImpl();
          //Product p = d.getProductById(15);
        }
    */
}
