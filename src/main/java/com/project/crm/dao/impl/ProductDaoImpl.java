package com.project.crm.dao.impl;


import com.project.crm.dao.DAO;
import com.project.crm.dao.ProductDao;
import com.project.crm.model.Product;
import com.project.crm.model.enums.Status;
import com.project.crm.services.SqlService;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;
import java.util.Date;


@Component
public class ProductDaoImpl extends DAO implements ProductDao {

    @Override
    public void addProduct(Product product) {
        Connection connection = poolInst.getConnection();
        try {
           connection.setAutoCommit(false);
           PreparedStatement statement;
           ResultSet resultSet;
           String newObjectTypeId = null;
           Map<String, String> attributesAndValues;

           statement = connection.prepareStatement(sql.
                   getProperty(SqlService.SQL_GET_PRODUCT_OBJECT_TYPE_ID));
           resultSet = statement.executeQuery();

           while(resultSet.next()) {
              newObjectTypeId = resultSet.getString(1);
           }
           statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_INSERT_INTO_OBJECT));

           String newObjectId = UUID.randomUUID().toString();
           statement.setString(1, newObjectId);
           statement.setString(2, newObjectTypeId);
           statement.execute();

           attributesAndValues = product.getAttributesAndValues();

           String attributesAttrId = null;
           for (Map.Entry entry: attributesAndValues.entrySet()) {
                //Получаем атрибуты и их значения
                String currentAttribute = (String) entry.getKey();
                String currentAttributeValue = (String) entry.getValue();
                //Получаем подходящий attr_id
                statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_SELECT_NECESSARY_ATTR_ID));
                statement.setString(1, newObjectTypeId);
                statement.setString(2, currentAttribute);
                ResultSet attributesAttrIdSet = statement.executeQuery();
                while(attributesAttrIdSet.next()) {
                    attributesAttrId = attributesAttrIdSet.getString(1);
                }
                statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_ADD_OBJECT));
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, attributesAttrId);
                statement.setString(4, currentAttributeValue);
                statement.execute();
           }
           statement = connection.prepareStatement(sql.
                   getProperty(SqlService.SQL_GET_CATEGORY_ATTR_ID));
           resultSet = statement.executeQuery();
           statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
            while(resultSet.next()) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, resultSet.getString(1));
                statement.setString(4, product.getCategory());
                statement.execute();
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_SUPERCATEGORY_ATTR_ID));
            resultSet = statement.executeQuery();
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
            while(resultSet.next()) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, resultSet.getString(1));
                statement.setString(4, product.getSuperCategory());
                statement.execute();
            }
           statement.close();
           resultSet.close();
           connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);
        } finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }
    }

    @Override
    public void editProduct(String id, Product product) {
        Connection connection = poolInst.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement;
            ResultSet resultSet = null;
            Map<String, String> attributesAndValues = product.getAttributesAndValues();

            //StringBuilder unionForUpdate = new StringBuilder("");

            StringBuilder unionForUpdate = new StringBuilder("UPDATE spring_security_app.values JOIN ( ");

            boolean first = true;
            for (Map.Entry entry: attributesAndValues.entrySet()) {
                if(first){

                    unionForUpdate.append("select '");
                    unionForUpdate.append((String) entry.getValue());
                    unionForUpdate.append("' as v1, '");

                    statement = connection.prepareStatement(sql.
                            getProperty(SqlService.SQL_GET_VALUES_ID_BY_OBJECT_ID_AND_ATTRIBUTES_NAME));
                    statement.setString(1, id);
                    statement.setString(2, (String) entry.getKey());
                    resultSet = statement.executeQuery();
                    resultSet.next();

                    unionForUpdate.append(resultSet.getString(1));
                    unionForUpdate.append("' as v2");
                }else {

                    unionForUpdate.append(" union select '");
                    unionForUpdate.append((String) entry.getValue());
                    unionForUpdate.append("', '");

                    statement = connection.prepareStatement(sql.
                            getProperty(SqlService.SQL_GET_VALUES_ID_BY_OBJECT_ID_AND_ATTRIBUTES_NAME));
                    statement.setString(1, id);
                    statement.setString(2, (String) entry.getKey());
                    resultSet = statement.executeQuery();
                    resultSet.next();

                    unionForUpdate.append(resultSet.getString(1));
                    unionForUpdate.append("'");

                }
                first = false;
            }

            unionForUpdate.append(" ) A ON A.v2=spring_security_app.values.value_id SET spring_security_app.values.Value = A.v1");

//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_EDIT_PRODUCT_BY_ID));
//            statement.setString(1, unionForUpdate.toString());

            statement = connection.prepareStatement(unionForUpdate.toString());
            statement.execute();


            statement.close();
            resultSet.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);
        } finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }
    }

    @Override
    public Product getProductById(String id) {
        Connection connection = poolInst.getConnection();
        Product currentProduct = new Product();
        currentProduct.setId(id);
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement;
            ResultSet resultSet;
            Map<String, String> attributesAndValues = new HashMap<>();

            statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCT_ATTR_VALS_AND_ATTR_IDS));
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                if(resultSet.getString(1).equals("CATEGORY")) {
                    currentProduct.setCategory(resultSet.getString(2));
                } else if(resultSet.getString(1).equals("SUPERCATEGORY")) {
                    currentProduct.setSuperCategory(resultSet.getString(2));
                } else attributesAndValues.put(
                        resultSet.getString(1),
                        resultSet.getString(2));
            }
            currentProduct.setAttributesAndValues(attributesAndValues);
            resultSet.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);
        }
        finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }
        return currentProduct;
    }

    @Override
    public List<Product> getProductsByTitle(String title) {  //Пока нет в базе
        Connection connection = poolInst.getConnection();

        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfTargetCategory = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCTS_BY_CATEGORY));
            statement.setString(1, category);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfTargetCategory.add(getProductById(setOfTargetObjectIds.getString(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);
        }
        finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }
        return productsOfTargetCategory;
    }

    @Override
    public List<Product> getProductsAfterDate(Date date) {   //Пока нет в базе
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public List<Product> getProductByStatus(Status status) {  // Пока нет в базе
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        Connection connection = poolInst.getConnection();
        List<Product> allProducts = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_ALL_PRODUCTS));
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                allProducts.add(getProductById(setOfTargetObjectIds.getString(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);
        }
        finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }
        return allProducts;
    }

    @Override
    public void deleteProductById(String id) {
        Connection connection = poolInst.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement;
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_DELETE_VALUES_BY_OBJECT_ID));
            statement.setString(1, id);
            statement.execute();

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_DELETE_OBJECT_BY_ID));
            statement.setString(1, id);
            statement.execute();

            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);
        }
        finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }
    }

    void tryToRollbackConnection(Connection connection) {
        try {
            connection.rollback();
            System.err.print("Transaction is being rolled back!");
        } catch (SQLException e) {
            System.err.print("Transaction is NOT being rolled back!");
            e.printStackTrace();
        }
    }

    void tryToSetAutoCommitTrueForConnection(Connection connection) {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        Connection connection = null;
//        try {
//            ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
//            String driverName = resourceBundle.getString("jdbc.driverClassName");
//            String url = resourceBundle.getString("jdbc.url");
//            String user = resourceBundle.getString("jdbc.username");
//            String password = resourceBundle.getString("jdbc.password");
//            Driver driver =  (Driver)Class.forName(driverName).newInstance();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection(url, user, password);
//            connection.setAutoCommit(false);
//        }
//        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
//            e.printStackTrace();
//
//        }
//
//
//        try {
//            String newObjID = UUID.randomUUID().toString();
//            PreparedStatement statement = connection.prepareStatement("Some query");
//            statement.setString(1, newObjID);
//            statement.execute();
//
//
//            statement.close();
//            connection.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
        ProductDaoImpl pDaoImpl = new ProductDaoImpl();
        List<Product> lst = new ArrayList<>();
        lst = pDaoImpl.getAllProducts();
        int i = 0;
        for(Product x : lst ) {
            System.out.println(i++ +". "+ x.toString());
        }
        System.out.println("------------------------------");
        Product p = new Product();
        p.setCategory("WOMEN_CLOTHING");
        p.setSuperCategory("Fashion");
        Map<String, String> map = new HashMap<>();
        map.put("SIZE_", "TEST");
        map.put("CONDITION", "TEST");
        map.put("SEASONS", "TEST");
        map.put("COST", "TEST");
        map.put("KIND_OF_CLOTHES", "TEST");
        map.put("OWNER", "TEST");
        p.setAttributesAndValues(map);
        pDaoImpl.addProduct(p);
        lst = pDaoImpl.getAllProducts();
        //------------------------
        i = 0;
        for(Product x : lst ) {
            System.out.println(i++ +". "+ x.toString());
        }

    }

}