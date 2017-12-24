package com.project.crm.services;

import com.project.crm.connectionPool.DbConnectionPool;
import java.util.ResourceBundle;

public class IDsLikeService {

    private static final String IDS_FILE = "./attributes_ids/user_IDs";

    private static IDsLikeService instance;
    private static ResourceBundle bundle;

    private IDsLikeService(){}

    public static IDsLikeService getInstance(){
        if(instance == null){
            synchronized (DbConnectionPool.class){
                instance = new IDsLikeService();
                bundle = ResourceBundle.getBundle(IDS_FILE);
            }
        }
        return instance;
    }

    public String getProperty(String key){
        return bundle.getString(key);
    }

}
