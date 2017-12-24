package com.project.crm.dao;

import com.project.crm.connectionPool.DbConnectionPool;
import com.project.crm.services.*;

/**
 * The class that initializes {@link DbConnectionPool} and {@link SqlService}
 */
public abstract class DAO {

    protected static DbConnectionPool poolInst;
    protected static SqlService sql;
    protected static IDsProductService productAttrID;
    protected static IDsCategoryService categoryAttrID;
    protected static IDsCommentService commentAttrID;
    protected static IDsLikeService likeAttrID;
    protected static IDsUserService userAttrID;

    protected DAO() {
        poolInst = DbConnectionPool.getInstance();
        sql = SqlService.getInstance();
        productAttrID = IDsProductService.getInstance();
        categoryAttrID = IDsCategoryService.getInstance();
        commentAttrID = IDsCommentService.getInstance();
        likeAttrID = IDsLikeService.getInstance();
        userAttrID = IDsUserService.getInstance();
    }
}
