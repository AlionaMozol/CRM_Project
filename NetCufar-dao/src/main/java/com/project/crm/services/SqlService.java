package com.project.crm.services;

import com.project.crm.connectionPool.DbConnectionPool;

import java.util.ResourceBundle;

public class SqlService {

    private static SqlService instance;
    private static ResourceBundle bundle;

    //user query
//    public static final String SQL_GET_USER_FROM_ID =              "SQL_GET_USER_FROM_ID";

    private static final String SQL_FILE = "sql";

//    public static final String SQL_GET_OWNER_ATTR_ID =             "SQL_GET_OWNER_ATTR_ID";
//    public static final String SQL_GET_COST_ATTR_ID =              "SQL_GET_COST_ATTR_ID";
//    public static final String SQL_GET_ATTR_ID_OF =                "SQL_GET_ATTR_ID_OF";
//    public static final String SQL_GET_PRODUCTS_BY_STATUS =        "SQL_GET_PRODUCTS_BY_STATUS";

    public static final String SQL_GET_USER_BY_ID =                "SQL_GET_USER_BY_ID";
//    public static final String SQL_ADD_USER =                      "SQL_ADD_USER";
    public static final String SQL_GET_USER_BY_USERNAME =          "SQL_GET_USER_BY_USERNAME";
//    public static final String SQL_CHECK_USER =                    "SQL_CHECK_USER";
//    public static final String SELECT_ALL_USERS =                  "SELECT_ALL_USERS";
//    public static final String SQL_GET_PRODUCTS_BY_CATEGORY =      "SQL_GET_PRODUCTS_BY_CATEGORY";
//    public static final String SQL_GET_PRODUCTS_BY_SUPERCATEGORY = "SQL_GET_PRODUCTS_BY_SUPERCATEGORY";
//    public static final String SQL_GET_ALL_PRODUCTS =              "SQL_GET_ALL_PRODUCTS";
    public  static final String SQL_OBJECTS_BY_OBJECT_TYPE =       "SQL_OBJECTS_BY_OBJECT_TYPE";
    public static final String SQL_DELETE_OBJECT_BY_ID =           "SQL_DELETE_OBJECT_BY_ID";
    public static final String SQL_DELETE_VALUES_BY_OBJECT_ID =    "SQL_DELETE_VALUES_BY_OBJECT_ID";

    public static final String SQL_INSERT_INTO_OBJECT =            "SQL_INSERT_INTO_OBJECT";
    public static final String SQL_SELECT_NECESSARY_ATTR_ID =      "SQL_SELECT_NECESSARY_ATTR_ID";
    public static final String SQL_INSERT_COMMENT_INTO_VALUES =    "SQL_INSERT_COMMENT_INTO_VALUES";
    public static final String  SQL_GET_PRODUCT_ATTR_VALS_AND_ATTR_IDS =
            "SQL_GET_PRODUCT_ATTR_VALS_AND_ATTR_IDS";
//    public static final String SQL_GET_PRODUCT_OBJECT_TYPE_ID =    "SQL_GET_PRODUCT_OBJECT_TYPE_ID";
//    public static final String SQL_GET_CATEGORY_ATTR_ID =          "SQL_GET_CATEGORY_ATTR_ID";
//    public static final String SQL_GET_SUPERCATEGORY_ATTR_ID =     "SQL_GET_SUPERCATEGORY_ATTR_ID";
    public static final String SQL_GET_ALL_SUPERCATEGORIES =       "SQL_GET_ALL_SUPERCATEGORIES";
//    public static final String SQL_GET_SUBCATEGORIES_BY_CATEGORY = "SQL_GET_SUBCATEGORIES_BY_CATEGORY";
//    public static final String SQL_GET_ALL_CATEGORIES =            "SQL_GET_ALL_CATEGORIES";
//    public static final String SQL_SELECT_BY_OBJECT_TYPE =         "SQL_SELECT_BY_OBJECT_TYPE";

    public static final String SQL_ADD_OBJECT =                    "SQL_ADD_OBJECT";
//    public static final String SQL_SELECT_FROM_OBJECT_TYPE_BY_VALUE =
//            "SQL_SELECT_FROM_OBJECT_TYPE_BY_VALUE";
//    public static final String SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR =
//            "SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR";
    public static final String SQL_INSERT_VALUE =                  "SQL_INSERT_VALUE";
    public static final String SQL_SELECT_OBJECT_ID_BY_VALUE =     "SQL_SELECT_OBJECT_ID_BY_VALUE";
    public static final String SQL_DELETE_VALUES =                 "SQL_DELETE_VALUES";
//    public static final String SQL_SELECT_OBJECT_ID_FROM_VALUES_AND_ATTR =
//            "SQL_SELECT_OBJECT_ID_FROM_VALUES_AND_ATTR";
    public static final String SQL_SELECT_USER_ATTRIBUTES =        "SQL_SELECT_USER_ATTRIBUTES";
//    public static final String SQL_GET_PRODUCT_BY_USER_ID =        "SQL_GET_PRODUCT_BY_USER_ID";
//    public static final String SQL_GET_USER_OBJECT_ID_BY_ID =      "SQL_GET_USER_OBJECT_ID_BY_ID";


    public static final String SQL_EDIT_PRODUCT_ATTRIBUTE =         "SQL_EDIT_PRODUCT_ATTRIBUTE";
    public static final String SQL_EDIT_PRODUCT_STATUS_BY_ID =      "SQL_EDIT_PRODUCT_STATUS_BY_ID";
    public static final String SQL_GET_USER_ATTR_BY_USERNAME =     "SQL_GET_USER_ATTR_BY_USERNAME";
    public static final String SQL_GET_USER_PHONE_BY_USER_ID =      "SQL_GET_USER_PHONE_BY_USER_ID";
//    public static final String SQL_GET_VALUES_ID_BY_OBJECT_ID_AND_ATTRIBUTES_NAME =
//                                                                     "SQL_GET_VALUES_ID_BY_OBJECT_ID_AND_ATTRIBUTES_NAME";

    public static final String SQL_GET_ATTRIBUTES_BY_CATEGORY_NAME =      "SQL_GET_ATTRIBUTES_BY_CATEGORY_NAME";

    public static final String SQL_GET_OBJECT_ID_BY_ATTR_ID_AND_VALUE =
                                                                     "SQL_GET_OBJECT_ID_BY_ATTR_ID_AND_VALUE";
    public static final String SQL_GET_OBJECT_ID_BY_TWO_ATTR_ID_AND_VALUE =
                                                                     "SQL_GET_OBJECT_ID_BY_TWO_ATTR_ID_AND_VALUE";
//    public static final String SQL_GET_OBJECT_ATTR_ID =             "SQL_GET_OBJECT_ATTR_ID";
//    public static final String SQL_GET_PHOTO_ATTR_ID =               "SQL_GET_PHOTO_ATTR_ID";

    public static final String SQL_GET_LIKES_BY_USERNAME =           "SQL_GET_LIKES_BY_USERNAME";
//    public static final String SQL_GET_LIKE_ATTR_ID =                "SQL_GET_LIKE_ATTR_ID";
//    public static final String SQL_GET_LIKE_OBJECT_TYPE_ID =         "SQL_GET_LIKE_OBJECT_TYPE_ID";
    public static final String SQL_GET_PRODUCT_BY_LIKE_ID =          "SQL_GET_PRODUCT_BY_LIKE_ID";
    public static final String SQL_INSERT_LIKE_INTO_VALUES =         "SQL_INSERT_LIKE_INTO_VALUES";

//    public static final String SQL_GET_TITLE_ATTR_ID =               "SQL_GET_TITLE_ATTR_ID";
//    public static final String SQL_GET_STATUS_ATTR_ID =              "SQL_GET_STATUS_ATTR_ID";
//    public static final String SQL_GET_DESCRIPTION_ATTR_ID =         "SQL_GET_DESCRIPTION_ATTR_ID";
//    public static final String SQL_GET_PRODUCT_CREATE_DATE_TIME_ATTR_ID =
//                                                                     "SQL_GET_PRODUCT_CREATE_DATE_TIME_ATTR_ID";
//    public static final String SQL_GET_PRODUCT_LAST_EDIT_DATE_TIME_ATTR_ID =
//                                                                     "SQL_GET_PRODUCT_LAST_EDIT_DATE_TIME_ATTR_ID";
    public static final String SQL_UPDATE_PROFILE =                  "SQL_UPDATE_PROFILE";

    public static final String SQL_GET_ALL_USERS =                   "SQL_GET_ALL_USERS";
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
