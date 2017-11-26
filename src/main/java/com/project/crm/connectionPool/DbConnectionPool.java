package com.project.crm.connectionPool;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class DbConnectionPool {


    private String url;
    private String user;
    private String password;
    private String driverName;


    private static DbConnectionPool instance;

    private Deque<Connection> deque;

    private DbConnectionPool(){

        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
            driverName = resourceBundle.getString("jdbc.driverClassName");
            url = resourceBundle.getString("jdbc.url");
            user = resourceBundle.getString("jdbc.username");
            password = resourceBundle.getString("jdbc.password");
            Driver driver =  (Driver)Class.forName(driverName).newInstance();
            DriverManager.registerDriver(driver);
            this.deque = new LinkedList<Connection>();

        }
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
            e.printStackTrace();

        }
    }

    public synchronized Connection getConnection() {
        //System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        //System.out.println("FROM GET CONNECTION: " + TransactionSynchronizationManager.getCurrentTransactionName());
        if (!deque.isEmpty()) {
            while (!deque.isEmpty()) {
                Connection connection;
                connection = deque.poll();
                return connection;
            }
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void footConnection(Connection connection) {
        try {
            if (!connection.isClosed()) {
                deque.add(connection);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static DbConnectionPool getInstance() {
        if (instance == null) {
            synchronized (DbConnectionPool.class) {
                instance = new DbConnectionPool();
                return instance;
            }
        }
        return instance;
    }
}


