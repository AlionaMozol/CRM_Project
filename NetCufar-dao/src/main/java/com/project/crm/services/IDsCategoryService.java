package com.project.crm.services;

import com.project.crm.connectionPool.DbConnectionPool;
import java.util.ResourceBundle;

public class IDsCategoryService {

    private static final String IDS_FILE = "./attributes_ids/category_IDs";

    private static IDsCategoryService instance;
    private static ResourceBundle bundle;

    private IDsCategoryService(){}

    public static IDsCategoryService getInstance(){
        if(instance == null){
            synchronized (DbConnectionPool.class){
                instance = new IDsCategoryService();
                bundle = ResourceBundle.getBundle(IDS_FILE);
            }
        }
        return instance;
    }

    public String getProperty(String key){
        return bundle.getString(key);
    }

}
