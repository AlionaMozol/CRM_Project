package com.project.crm.dao;

import com.project.crm.connectionPool.DbConnectionPool;
import com.project.crm.services.SqlService;

public abstract class DAO {

    protected static DbConnectionPool poolInst;
    protected static SqlService sql;

    protected DAO(){
        poolInst = DbConnectionPool.getInstance();
        sql=SqlService.getInstance();
    }
}
