package com.project.crm.connectionPool;

import com.project.crm.xml.ConfigParser;

import org.apache.commons.dbcp.BasicDataSource;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Deque;
import java.util.LinkedList;


public class DbConnectionPool {


    private String url;
    private String user;
    private String password;
    private String driverName;
    private static final String CONFIG_XML = "config.xml";

    private static DbConnectionPool instance;
   private Deque<Connection> deque;


    private DbConnectionPool(){
        ConfigParser configParser = new ConfigParser();
        try {
            configParser.parseConfig(CONFIG_XML);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            driverName = configParser.getDriver();
            url = configParser.getUrl();
            user = configParser.getLogin();
            password = configParser.getPassword();
            Driver driver =  (Driver)Class.forName(driverName).newInstance();
            DriverManager.registerDriver(driver);
            this.deque = new LinkedList<Connection>();

        }catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
            e.printStackTrace();

        }
    }

    public static synchronized DbConnectionPool getInstance(){
        if(instance == null) {
            synchronized (DbConnectionPool.class){
            instance = new DbConnectionPool();
            return instance;
        }
        }
        return instance;
    }

    public synchronized Connection getConnection() {
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
    public static void main(String[] args){

        ConfigParser configParser = new ConfigParser();
        try {
            configParser.parseConfig(CONFIG_XML);
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println("SAXEX");
        } catch (IOException e) {
            System.out.println("IOEX");
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            System.out.println("parserconfi");
            e.printStackTrace();
        }
        System.out.println(configParser.getUrl());

    }
}


