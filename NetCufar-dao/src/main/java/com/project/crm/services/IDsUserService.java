package com.project.crm.services;

import com.project.crm.connectionPool.DbConnectionPool;
import java.util.ResourceBundle;

public class IDsUserService {

    private static final String IDS_FILE = "./attributes_ids/user_IDs";

    private static IDsUserService instance;
    private static ResourceBundle bundle;

    private IDsUserService(){}

    public static IDsUserService getInstance(){
        if(instance == null){
            synchronized (DbConnectionPool.class){
                instance = new IDsUserService();
                bundle = ResourceBundle.getBundle(IDS_FILE);
            }
        }
        return instance;
    }

    public String getProperty(String key){
        return bundle.getString(key);
    }

}
