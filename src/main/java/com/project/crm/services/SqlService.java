package com.project.crm.services;

import com.project.crm.connectionPool.DbConnectionPool;

import java.util.ResourceBundle;

public class SqlService {

    private static SqlService instance;
    private static ResourceBundle bundle;

    public static final String SQL_FILE = "sql";

    //user query
    public static final String SQL_GET_USER_FROM_ID = "SQL_GET_USER_FROM_ID";





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

    public String getPropertie(String key){
        return bundle.getString(key);
    }

}
