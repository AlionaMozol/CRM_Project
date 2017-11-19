package com.project.crm.services;

import com.project.crm.connectionPool.DbConnectionPool;

import java.util.ResourceBundle;

public class SqlService {

    private static SqlService instance;
    private static ResourceBundle bundle;

    private static final String SQL_FILE = "sql";

    //user query
    public static final String SQL_GET_USER_FROM_ID =              "SQL_GET_USER_FROM_ID";
    public static final String SQL_ADD_USER =                      "SQL_ADD_USER";
    public static final String SQL_GET_USER_FROM_USERNAME =        "SQL_GET_USER_FROM_USERNAME";
    public static final String SQL_CHECK_USER =                    "SQL_CHECK_USER";
    public static final String SELECT_ALL_USERS =                  "SELECT_ALL_USERS";
    public static final String SQL_GET_PRODUCTS_BY_CATEGORY =      "SQL_GET_PRODUCTS_BY_CATEGORY";
    public static final String SQL_GET_ALL_PRODUCTS =              "SQL_GET_ALL_PRODUCTS";
    public static final String SQL_DELETE_OBJECT_BY_ID =           "SQL_DELETE_OBJECT_BY_ID";
    public static final String SQL_DELETE_VALUES_BY_OBJECT_ID =    "SQL_DELETE_VALUES_BY_OBJECT_ID";

    public static final String SQL_INSERT_INTO_OBJECT =            "SQL_INSERT_INTO_OBJECT";
    public static final String SQL_SELECT_NECESSARY_ATTR_ID =      "SQL_SELECT_NECESSARY_ATTR_ID";
    public static final String SQL_ADD_OBJECT =                    "SQL_ADD_OBJECT";
    public static final String  SQL_GET_PRODUCT_ATTR_VALS_AND_ATTR_IDS =
                                                                   "SQL_GET_PRODUCT_ATTR_VALS_AND_ATTR_IDS";
    public static final String SQL_GET_PRODUCT_OBJECT_TYPE_ID =    "SQL_GET_PRODUCT_OBJECT_TYPE_ID";
    public static final String SQL_GET_CATEGORY_ATTR_ID =          "SQL_GET_CATEGORY_ATTR_ID";
    public static final String SQL_GET_SUPERCATEGORY_ATTR_ID =     "SQL_GET_SUPERCATEGORY_ATTR_ID";

    public static final String SQL_GET_ATTRIBUTES_BY_CATEGORY =      "SQL_GET_ATTRIBUTES_BY_CATEGORY";

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
