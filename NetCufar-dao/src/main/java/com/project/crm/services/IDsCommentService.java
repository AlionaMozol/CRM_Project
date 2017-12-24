package com.project.crm.services;

import com.project.crm.connectionPool.DbConnectionPool;
import java.util.ResourceBundle;

public class IDsCommentService {

    private static final String IDS_FILE = "./attributes_ids/comment_IDs";

    private static IDsCommentService instance;
    private static ResourceBundle bundle;

    private IDsCommentService(){}

    public static IDsCommentService getInstance(){
        if(instance == null){
            synchronized (DbConnectionPool.class){
                instance = new IDsCommentService();
                bundle = ResourceBundle.getBundle(IDS_FILE);
            }
        }
        return instance;
    }

    public String getProperty(String key){
        return bundle.getString(key);
    }

}
