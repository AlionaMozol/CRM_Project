package com.project.crm.services;

import com.project.crm.connectionPool.DbConnectionPool;

import java.util.ResourceBundle;

public class SqlService {

    private static SqlService instance;
    private static ResourceBundle bundle;

    private static final String SQL_FILE = "sql";

    //user query
    public static final String SQL_GET_USER_FROM_ID = "SQL_GET_USER_FROM_ID";
    public static final String SQL_ADD_USER = "SQL_ADD_USER";
    public static final String SQL_GET_USER_FROM_USERNAME = "SQL_GET_USER_FROM_USERNAME";
    public static final String SQL_CHECK_USER = "SQL_CHECK_USER";
    public static final String SELECT_ALL_USERS = "SELECT_ALL_USERS";

    public static final String SQL_GET_PRODUCTS_BY_CATEGORY = "SQL_GET_PRODUCTS_BY_CATEGORY";
    public static final String SQL_GET_PRODUCTS_BETWEEN_2_PRICES = "SQL_GET_PRODUCTS_BETWEEN_2_PRICES";
    public static final String SQL_GET_ALL_PRODUCTS = "SQL_GET_ALL_PRODUCTS";

    public static final String SQL_GET_PRODUCT_BY_ID = "SQL_GET_PRODUCT_BY_ID";
    public static final String SQL_GET_PRODUCT_TYPE_BY_ID = "SQL_GET_PRODUCT_TYPE_BY_ID";
    public static final String SQL_GET_ATTRIBUTE_COST_BY_OBJECT_TYPE_ID = "SQL_GET_ATTRIBUTE_COST_BY_OBJECT_TYPE_ID";
    public static final String SQL_GET_COST_BY_ATTRIBUTE_ID_AND_OBJECT_ID = "SQL_GET_COST_BY_ATTRIBUTE_ID_AND_OBJECT_ID";



    private SqlService(){}

    public static SqlService getInstance(){
        if(instance == null){
            synchronized (DbConnectionPool.class){
                instance = new SqlService();
                bundle = ResourceBundle.getBundle(SQL_FILE);
            }
        }
        return instance;
    }

    public String getProperty(String key){
        return bundle.getString(key);
    }

}
