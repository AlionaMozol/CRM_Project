package com.project.crm.dao.impl;


import com.project.crm.dao.DAO;
import com.project.crm.dao.ProductDao;
import com.project.crm.model.Product;
import com.project.crm.model.enums.ProductStatus;
import com.project.crm.services.SqlService;
import javafx.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
//           statement = connection.prepareStatement(sql.
//                   getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//           statement.setString(1, "CATEGORY");
//           resultSet = statement.executeQuery();
//           statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_ADD_OBJECT));
//            while(resultSet.next()) {
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setString(2, newObjectId);
//                statement.setString(3, resultSet.getString(1));
//                statement.setString(4, product.getCategory());
//                statement.execute();
//            }
            buildAndExecuteStatement(connection, "CATEGORY", UUID.randomUUID().toString(),
                    newObjectId, product.getCategory());

//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//            statement.setString(1, "SUPERCATEGORY");
//            resultSet = statement.executeQuery();
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_ADD_OBJECT));
//            while(resultSet.next()) {
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setString(2, newObjectId);
//                statement.setString(3, resultSet.getString(1));
//                statement.setString(4, product.getSuperCategory());
//                statement.execute();
//            }
            buildAndExecuteStatement(connection, "SUPERCATEGOTY", UUID.randomUUID().toString(),
                    newObjectId, product.getSuperCategory());

//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//            statement.setString(1, "OWNER");
//            resultSet = statement.executeQuery();
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_ADD_OBJECT));
//            while(resultSet.next()) {
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setString(2, newObjectId);
//                statement.setString(3, resultSet.getString(1));
//                statement.setString(4, product.getOwner());
//                statement.execute();
//            }
            buildAndExecuteStatement(connection, "OWNER", UUID.randomUUID().toString(),
                    newObjectId, product.getOwner());
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//            statement.setString(1, "COST");
//            resultSet = statement.executeQuery();
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_ADD_OBJECT));
//            while(resultSet.next()) {
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setString(2, newObjectId);
//                statement.setString(3, resultSet.getString(1));
//                statement.setString(4, product.getCost());
//                statement.execute();
//            }
            buildAndExecuteStatement(connection, "COST", UUID.randomUUID().toString(),
                    newObjectId, product.getCost());

//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//            statement.setString(1, "STATUS");
//            resultSet = statement.executeQuery();
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_ADD_OBJECT));
//            while(resultSet.next()) {
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setString(2, newObjectId);
//                statement.setString(3, resultSet.getString(1));
//                statement.setString(4, "MODERATION");
//                statement.execute();
//            }
            buildAndExecuteStatement(connection, "STATUS", UUID.randomUUID().toString(),
                    newObjectId, "MODERATION");

//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//            statement.setString(1, "TITLE");
//            resultSet = statement.executeQuery();
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_ADD_OBJECT));
//            while(resultSet.next()) {
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setString(2, newObjectId);
//                statement.setString(3, resultSet.getString(1));
//                statement.setString(4, product.getTitle());
//                statement.execute();
//            }
            buildAndExecuteStatement(connection, "TITLE", UUID.randomUUID().toString(),
                    newObjectId, product.getTitle());

//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//            statement.setString(1, "DESCRIPTION");
//            resultSet = statement.executeQuery();
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_ADD_OBJECT));
//            while(resultSet.next()) {
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setString(2, newObjectId);
//                statement.setString(3, resultSet.getString(1));
//                statement.setString(4, product.getDescription());
//                statement.execute();
//            }
            buildAndExecuteStatement(connection, "DESCRIPTION", UUID.randomUUID().toString(),
                    newObjectId, product.getDescription());

            buildAndExecuteStatement(connection, "PHOTO", UUID.randomUUID().toString(),
                    newObjectId, product.getPhoto());


            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//            statement.setString(1, "PRODUCT_LAST_EDIT_DATE_TIME");
//            resultSet = statement.executeQuery();
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_ADD_OBJECT));
//            while(resultSet.next()) {
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setString(2, newObjectId);
//                statement.setString(3, resultSet.getString(1));
//                statement.setString(4, formatter.format(new Date(System.currentTimeMillis())));
//                statement.execute();
//            }
            buildAndExecuteStatement(connection, "PRODUCT_LAST_EDIT_DATE_TIME", UUID.randomUUID().toString(),
                    newObjectId, formatter.format(new Date(System.currentTimeMillis())));

//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//            statement.setString(1, "PRODUCT_CREATE_DATE_TIME");
//            resultSet = statement.executeQuery();
//            statement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_ADD_OBJECT));
//            while(resultSet.next()) {
//                statement.setString(1, UUID.randomUUID().toString());
//                statement.setString(2, newObjectId);
//                statement.setString(3, resultSet.getString(1));
//                statement.setString(4, formatter.format(new Date(System.currentTimeMillis())));
//                statement.execute();
//            }
            buildAndExecuteStatement(connection, "PRODUCT_CREATE_DATE_TIME", UUID.randomUUID().toString(),
                    newObjectId, formatter.format(new Date(System.currentTimeMillis())));

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

            StringBuilder unionForUpdate = new StringBuilder("UPDATE values_table JOIN ( ");

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

            unionForUpdate.append(" ) A ON A.v2=values_table.value_id SET values_table.Value = A.v1");

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
                //resultSet.getString(1) - имя атрибута
                //resultSet.getString(2) - его значение
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
                } else if(resultSet.getString(1).equals("PHOTO")) {
                    currentProduct.setPhoto(resultSet.getString(2));
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
    public List<Product> getProductsByKeyWords(String keyWords) {
        Connection connection = poolInst.getConnection();
        List<Pair<Product, String>> productsAndTitles = new ArrayList<>();
        List<Product> matchedProducts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_ALL_PRODUCTS));
            ResultSet allProducts = statement.executeQuery();
            while (allProducts.next()) {
                Product product = getProductById(allProducts.getString(1));
                if(product.getTitle() != null) {
                    productsAndTitles.add(new Pair<>(product, product.getTitle()));
                }
            }
            String pattern = "(" + keyWords + ")" +
                    "|(" + keyWords.toLowerCase() + ")" +
                    "|(" + keyWords.toUpperCase() + ")";
            for(String part : keyWords.split("\\s")) {
                pattern = pattern + "|(" + part + ")";
                pattern = pattern + "|(" + part.toUpperCase() + ")";
                pattern = pattern + "|(" + part.toLowerCase() + ")";
            }
            Pattern pt = Pattern.compile(pattern);
            Matcher matcher;
            for(Pair <Product, String> productAndTitle : productsAndTitles) {
                matcher = pt.matcher(productAndTitle.getValue());
                if(matcher.find()) {
                    matchedProducts.add(productAndTitle.getKey());
                }
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return matchedProducts;
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
    public List<Product> getProductsAfterDate(Date date) {
        Connection connection = poolInst.getConnection();


        poolInst.footConnection(connection);
        return null;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public List<Product> getProductsByStatus(ProductStatus status) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfCurrentStatus = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCTS_BY_STATUS));
            statement.setString(1, status.name());
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfCurrentStatus.add(getProductById(setOfTargetObjectIds.getString(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return productsOfCurrentStatus;
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


    public void buildAndExecuteStatement(Connection connection, String attrType,
                                         String id, String newObjectId, String value) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(sql.
                getProperty(SqlService.SQL_GET_ATTR_ID_OF));
        statement.setString(1, attrType);
        ResultSet resultSet = statement.executeQuery();
        statement = connection.prepareStatement(sql.
                getProperty(SqlService.SQL_ADD_OBJECT));
        while(resultSet.next()) {
            statement.setString(1, id);
            statement.setString(2, newObjectId);
            statement.setString(3, resultSet.getString(1));
            statement.setString(4, value);
            statement.execute();
        }
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public List<Product> getProductsBySupercategory(String supercategory) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfTargetSupercategory = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCTS_BY_SUPERCATEGORY));
            statement.setString(1, supercategory);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfTargetSupercategory.add(getProductById(setOfTargetObjectIds.getString(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return productsOfTargetSupercategory;
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
        //===========================
    /*    Product p = new Product();
        p.setCategory("WOMEN_CLOTHING");
        p.setSuperCategory("Fashion");
        p.setOwner("SASHA");
        p.setCost("SASHA NUMBER 1");
//      p.setProductStatus(Status.MODERATION);
        p.setDescription("AAAAAAAAAAAAAAAAAAAAAAAA");
        p.setTitle("котик Джерри");
        Map<String, String> map = new HashMap<>();
        map.put("SIZE_", "TEST");
        map.put("CONDITION", "TEST");
        map.put("SEASONS", "TEST");
        map.put("KIND_OF_CLOTHES", "TEST");
        p.setAttributesAndValues(map);
        pDaoImpl.addProduct(p);
        lst = pDaoImpl.getProductsByKeyWords("Котик смешно падает смотреть онлайн");*/
        //===========================
        lst = pDaoImpl.getProductsBySupercategory("Animals");
        int i = 0;
        if (lst != null) {
            for (Product x : lst) {
                System.out.println(i++ + ". " + x.toString());
            }
        } else {
            System.out.println("Nothing to shown\n");
        }

    }

}