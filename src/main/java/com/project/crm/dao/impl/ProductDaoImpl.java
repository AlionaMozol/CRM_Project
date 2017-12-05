package com.project.crm.dao.impl;


import com.project.crm.dao.DAO;
import com.project.crm.dao.ProductDao;
import com.project.crm.model.Product;
import com.project.crm.model.enums.ProductStatus;
import com.project.crm.services.SqlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


@Component
public class ProductDaoImpl extends DAO implements ProductDao {

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public void addProduct(Product product) {
        Connection connection = poolInst.getConnection();
        try {
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

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_OWNER_ATTR_ID));
            resultSet = statement.executeQuery();
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
            while(resultSet.next()) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, resultSet.getString(1));
                statement.setString(4, product.getOwner());
                statement.execute();
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_COST_ATTR_ID));
            resultSet = statement.executeQuery();
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
            while(resultSet.next()) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, resultSet.getString(1));
                statement.setString(4, product.getCost());
                statement.execute();
            }
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_STATUS_ATTR_ID));
            resultSet = statement.executeQuery();
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
            while(resultSet.next()) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, resultSet.getString(1));
                statement.setString(4, "MODERATION");
                statement.execute();
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_TITLE_ATTR_ID));
            resultSet = statement.executeQuery();
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
            while(resultSet.next()) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, resultSet.getString(1));
                statement.setString(4, product.getTitle());
                statement.execute();
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_DESCRIPTION_ATTR_ID));
            resultSet = statement.executeQuery();
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
            while(resultSet.next()) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, resultSet.getString(1));
                statement.setString(4, product.getDescription());
                statement.execute();
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_PRODUCT_LAST_EDIT_DATE_TIME_ATTR_ID));
            resultSet = statement.executeQuery();
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

            while(resultSet.next()) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, resultSet.getString(1));
                statement.setString(4, formatter.format(new Date(System.currentTimeMillis())));
                statement.execute();
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_PRODUCT_CREATE_DATE_TIME_ATTR_ID));
            resultSet = statement.executeQuery();
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
            while(resultSet.next()) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, resultSet.getString(1));
                statement.setString(4, formatter.format(new Date(System.currentTimeMillis())));
                statement.execute();
            }
           statement.close();
           resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public List<Product> getProductsByUsername(String username) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfUser = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCT_BY_USER_ID));
            statement.setString(1, username);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfUser.add(getProductById(setOfTargetObjectIds.getString(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return productsOfUser;
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public void editProduct(String id, Product product) {
        Connection connection = poolInst.getConnection();
        try {
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

            statement = connection.prepareStatement(unionForUpdate.toString());
            statement.execute();

            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public Product getProductById(String id) {
        Connection connection = poolInst.getConnection();
        Product currentProduct = new Product();
        currentProduct.setId(id);
        try {
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
                } else if(resultSet.getString(1).equals("OWNER")) {
                    currentProduct.setOwner(resultSet.getString(2));
                } else if(resultSet.getString(1).equals("COST")) {
                    currentProduct.setCost(resultSet.getString(2));
                } else if(resultSet.getString(1).equals("TITLE")) {
                    currentProduct.setTitle(resultSet.getString(2));
                } else if(resultSet.getString(1).equals("DESCRIPTION")) {
                    currentProduct.setDescription(resultSet.getString(2));
                } else if(resultSet.getString(1).equals("STATUS")) {
                    currentProduct.setProductStatus(ProductStatus.valueOf(resultSet.getString(2)));
                } else if(resultSet.getString(1).equals("PRODUCT_CREATE_DATE_TIME")) {
                    currentProduct.setPublicationDate(resultSet.getString(2));
                } else if(resultSet.getString(1).equals("PRODUCT_LAST_EDIT_DATE_TIME")) {
                    currentProduct.setDateOfLastEdit(resultSet.getString(2));
                } else attributesAndValues.put(
                        resultSet.getString(1),
                        resultSet.getString(2));
            }
            currentProduct.setAttributesAndValues(attributesAndValues);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return currentProduct;
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public List<Product> getProductsByTitle(String title) {  //Пока нет в базе
        Connection connection = poolInst.getConnection();

        poolInst.footConnection(connection);
        return null;
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public List<Product> getProductsByCategory(String category) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfTargetCategory = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCTS_BY_CATEGORY));
            statement.setString(1, category);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfTargetCategory.add(getProductById(setOfTargetObjectIds.getString(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return productsOfTargetCategory;
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public List<Product> getProductsAfterDate(Date date) {   //Пока нет в базе
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
        return null;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public List<Product> getProductByStatus(ProductStatus status) {  // Пока нет в базе
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
        return null;
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public List<Product> getAllProducts() {
        Connection connection = poolInst.getConnection();
        List<Product> allProducts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_ALL_PRODUCTS));
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                allProducts.add(getProductById(setOfTargetObjectIds.getString(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return allProducts;
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public void deleteProductById(String id) {
        Connection connection = poolInst.getConnection();
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
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
        List<Product> lst;
        lst = pDaoImpl.getProductsByCategory("WOMEN_CLOTHING");
        int i = 0;
        for(Product x : lst ) {
            System.out.println(i++ +". "+ x.toString());
        }
        System.out.println("------------------------------");
        Product p = new Product();
        p.setCategory("WOMEN_CLOTHING");
        p.setSuperCategory("Fashion");
        p.setOwner("SASHA");
        p.setCost("SASHA NUMBER 1");
//        p.setProductStatus(Status.MODERATION);
        p.setDescription("AAAAAAAAAAAAAAAAAAAAAAAA");
        p.setTitle("PRODUCT");
        Map<String, String> map = new HashMap<>();
        map.put("SIZE_", "TEST");
        map.put("CONDITION", "TEST");
        map.put("SEASONS", "TEST");
        map.put("KIND_OF_CLOTHES", "TEST");
        p.setAttributesAndValues(map);
        pDaoImpl.addProduct(p);
        lst = pDaoImpl.getProductsByCategory("WOMEN_CLOTHING");
        //------------------------
        i = 0;
        for(Product x : lst ) {
            System.out.println(i++ +". "+ x.toString());
        }

    }

}