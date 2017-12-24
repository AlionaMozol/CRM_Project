package com.project.crm.services;

import com.project.crm.connectionPool.DbConnectionPool;
import java.util.ResourceBundle;

public class IDsProductService {

    private static final String IDS_FILE = "./attributes_ids/product_IDs";

    private static IDsProductService instance;
    private static ResourceBundle bundle;

    private IDsProductService(){}

    public static IDsProductService getInstance(){
        if(instance == null){
            synchronized (DbConnectionPool.class){
                instance = new IDsProductService();
                bundle = ResourceBundle.getBundle(IDS_FILE);
            }
        }
        return instance;
    }

    public String getProperty(String key){
        return bundle.getString(key);
    }
}
