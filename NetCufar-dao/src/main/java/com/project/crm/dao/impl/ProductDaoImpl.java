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

//-----non autowired bean search-----
//@Component
public class ProductDaoImpl extends DAO implements ProductDao {

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
    @Override
    public void addProduct(Product product) throws NullPointerException{
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement statement;
//            ResultSet resultSet;
//            String newObjectTypeId = null;
            Map<String, String> attributesAndValues;

//            statement = connection.prepareStatement(sql.
//                        getProperty(SqlService.SQL_GET_PRODUCT_OBJECT_TYPE_ID));
//            resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                newObjectTypeId = resultSet.getString(1);
//            }
            statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_INSERT_INTO_OBJECT));

            String newObjectId = UUID.randomUUID().toString();
            statement.setString(1, newObjectId);
            statement.setString(2, productAttrID.getProperty("OBJECT_TYPE_ID"));
            statement.execute();

            attributesAndValues = product.getAttributesAndValues();

            String attributesAttrId = null;
            for (Map.Entry entry : attributesAndValues.entrySet()) {
                //Получаем атрибуты и их значения
                String currentAttribute = (String) entry.getKey();
                String currentAttributeValue = (String) entry.getValue();
                //Получаем подходящий attr_id
                statement = connection.prepareStatement(sql.
                            getProperty(SqlService.SQL_SELECT_NECESSARY_ATTR_ID));
                statement.setString(1, productAttrID.getProperty("OBJECT_TYPE_ID"));
                statement.setString(2, currentAttribute);
                ResultSet attributesAttrIdSet = statement.executeQuery();
                while (attributesAttrIdSet.next()) {
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
            buildAndExecuteStatement(connection, "CATEGORY", UUID.randomUUID().toString(),
                    newObjectId, product.getCategory());

            buildAndExecuteStatement(connection, "SUPERCATEGORY", UUID.randomUUID().toString(),
                    newObjectId, product.getSuperCategory());

            buildAndExecuteStatement(connection, "OWNER", UUID.randomUUID().toString(),
                    newObjectId, product.getOwner());

            buildAndExecuteStatement(connection, "COST", UUID.randomUUID().toString(),
                    newObjectId, product.getCost());

            buildAndExecuteStatement(connection, "STATUS", UUID.randomUUID().toString(),
                    newObjectId, "MODERATION");

            buildAndExecuteStatement(connection, "TITLE", UUID.randomUUID().toString(),
                    newObjectId, product.getTitle());

            if(product.getDescription()!=null) {
                buildAndExecuteStatement(connection, "DESCRIPTION", UUID.randomUUID().toString(),
                        newObjectId, product.getDescription());
            }

            buildAndExecuteStatement(connection, "PHOTO", UUID.randomUUID().toString(),
                    newObjectId, product.getPhoto());

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            buildAndExecuteStatement(connection, "PRODUCT_LAST_EDIT_DATE_TIME", UUID.randomUUID().toString(),
                    newObjectId, formatter.format(new Date(System.currentTimeMillis())));

            buildAndExecuteStatement(connection, "PRODUCT_CREATE_DATE_TIME", UUID.randomUUID().toString(),
                    newObjectId, formatter.format(new Date(System.currentTimeMillis())));

            statement.close();
//            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
    @Override
    public List<Product> getProductsByUsername(String username) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfUser = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                                          getProperty(SqlService.SQL_GET_OBJECT_ID_BY_ATTR_ID_AND_VALUE));
            statement.setString(1, productAttrID.getProperty("OWNER"));
            statement.setString(2, username);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfUser.add(getProductById(setOfTargetObjectIds.getString(1)));
            }

            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return productsOfUser;
    }

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
    @Override
    public void editProduct(Product product) {
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_EDIT_PRODUCT_ATTRIBUTE));
            Map<String, String> attributesAndValues = product.getAttributesAndValues();

            for (Map.Entry entry: attributesAndValues.entrySet()) {
                editProductAttribute(
                        statement, (String) entry.getValue(), product.getId(),
                        productAttrID.getProperty((String) entry.getKey()));
            }

            editProductAttribute(statement, product.getTitle(), product.getId(), productAttrID.getProperty("TITLE"));
            editProductAttribute(statement, product.getCost(),  product.getId(), productAttrID.getProperty("COST" ));
            if(!product.getPhoto().equals("-1")) {
                editProductAttribute(statement, product.getPhoto(), product.getId(), productAttrID.getProperty("PHOTO"));
            }

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            editProductAttribute(statement, formatter.format(new Date(System.currentTimeMillis())),
                    product.getId(), productAttrID.getProperty("PRODUCT_LAST_EDIT_DATE_TIME"));

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
    @Override
    public Product getProductById(String id) {
        Connection connection = poolInst.getConnection();
        Product currentProduct = new Product();
        try {
            PreparedStatement statement;
            ResultSet resultSet;
            Map<String, String> attributesAndValues = new HashMap<>();
            String owner = "";

            statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_GET_PRODUCT_ATTR_VALS_AND_ATTR_IDS));
            statement.setString(1, id);
            resultSet = statement.executeQuery();
//            if(!resultSet.next()){
//                return null;
//            }
            currentProduct.setId(id);
            while (resultSet.next()) {
                //resultSet.getString(1) - имя атрибута
                //resultSet.getString(2) - его значение
                if (resultSet.getString(1).equals("CATEGORY")) {
                    currentProduct.setCategory(resultSet.getString(2));
                } else if (resultSet.getString(1).equals("SUPERCATEGORY")) {
                    currentProduct.setSuperCategory(resultSet.getString(2));
                } else if (resultSet.getString(1).equals("OWNER")) {
                    owner = resultSet.getString(2);
                    currentProduct.setOwner(owner);
                } else if (resultSet.getString(1).equals("COST")) {
                    currentProduct.setCost(resultSet.getString(2));
                } else if (resultSet.getString(1).equals("TITLE")) {
                    currentProduct.setTitle(resultSet.getString(2));
                } else if (resultSet.getString(1).equals("DESCRIPTION")) {
                    currentProduct.setDescription(resultSet.getString(2));
                } else if (resultSet.getString(1).equals("PHOTO")) {
                    currentProduct.setPhoto(resultSet.getString(2));
                } else if (resultSet.getString(1).equals("STATUS")) {
                    currentProduct.setProductStatus(ProductStatus.valueOf(resultSet.getString(2)));
                } else if (resultSet.getString(1).equals("PRODUCT_CREATE_DATE_TIME")) {
                    currentProduct.setPublicationDate(resultSet.getString(2));
                } else if (resultSet.getString(1).equals("PRODUCT_LAST_EDIT_DATE_TIME")) {
                    currentProduct.setDateOfLastEdit(resultSet.getString(2));
                } else if (resultSet.getString(1).equals("TELEPHONE")) {
                    currentProduct.setPhone(resultSet.getString(2));
                } else attributesAndValues.put(resultSet.getString(1),
                                               resultSet.getString(2));
            }
            currentProduct.setAttributesAndValues(attributesAndValues);
            //----
            statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_GET_USER_PHONE_BY_USERNAME));
            statement.setString(1, userAttrID.getProperty("TELEPHONE"));
            statement.setString(2, owner);
            statement.setString(3, userAttrID.getProperty("SECURITY_ID"));
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                currentProduct.setPhone(resultSet.getString(1));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return currentProduct;
    }

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
    @Override
    public List<Product> getProductsByKeyWords(String keyWords) {
        Connection connection = poolInst.getConnection();
        List<Pair<Product, String>> productsAndTitles = new ArrayList<>();
        List<Product> matchedProducts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                                          getProperty(SqlService.SQL_OBJECTS_BY_OBJECT_TYPE));
            statement.setString(1, productAttrID.getProperty("OBJECT_TYPE_ID"));
            ResultSet allProducts = statement.executeQuery();
            while (allProducts.next()) {
                Product product = getProductById(allProducts.getString(1));
                if (product.getTitle() != null) {
                    productsAndTitles.add(new Pair<>(product, product.getTitle()));
                }
            }
            StringBuilder pattern = new StringBuilder();
            pattern.append("(");
            pattern.append(Pattern.quote(keyWords.toLowerCase()));
            pattern.append(")");
            for (String part : keyWords.split("\\s")) {
                pattern.append("|(");
                pattern.append(Pattern.quote(part.toLowerCase()));
                pattern.append(")");
            }
            Pattern pt = Pattern.compile(pattern.toString());
            Matcher matcher;
            for(Pair<Product, String> productAndTitle : productsAndTitles) {
                matcher = pt.matcher(productAndTitle.getValue().toLowerCase());
                if (matcher.find()) {
                    matchedProducts.add(productAndTitle.getKey());
                }
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return matchedProducts;
    }

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
    @Override
    public List<Product> getProductsByCategory(String category) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfTargetCategory = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                                          getProperty(SqlService.SQL_GET_OBJECT_ID_BY_ATTR_ID_AND_VALUE));
            statement.setString(1, productAttrID.getProperty("CATEGORY"));
            statement.setString(2, category);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfTargetCategory.add(getProductById(setOfTargetObjectIds.getString(1)));
            }

            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return productsOfTargetCategory;
    }

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
    @Override
    public List<Product> getProductsByStatus(ProductStatus status) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfCurrentStatus = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_OBJECT_ID_BY_ATTR_ID_AND_VALUE));
            statement.setString(1, productAttrID.getProperty("STATUS"));
            statement.setString(2, status.name());
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfCurrentStatus.add(getProductById(setOfTargetObjectIds.getString(1)));
            }

            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return productsOfCurrentStatus;
    }

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
    @Override
    public List<Product> getAllProducts() {
        Connection connection = poolInst.getConnection();
        List<Product> allProducts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                                          getProperty(SqlService.SQL_OBJECTS_BY_OBJECT_TYPE));
            statement.setString(1, productAttrID.getProperty("OBJECT_TYPE_ID"));
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                allProducts.add(getProductById(setOfTargetObjectIds.getString(1)));
            }

            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return allProducts;
    }

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
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
        } finally {
            poolInst.footConnection(connection);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY,
                   rollbackFor = Exception.class)
    @Override
    public void changeProductStatus(String id, ProductStatus status) {
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_EDIT_PRODUCT_STATUS_BY_ID));
            statement.setString(1, status.toString());
            statement.setString(2, productAttrID.getProperty("STATUS"));
            statement.setString(3, id);
            statement.execute();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
    }

    private void buildAndExecuteStatement(Connection connection, String attrType,
                                         String id, String newObjectId, String value) throws SQLException {
//        PreparedStatement statement = connection.prepareStatement(sql.
//                                      getProperty(SqlService.SQL_GET_ATTR_ID_OF));
//        statement.setString(1, attrType);
//        ResultSet resultSet = statement.executeQuery();
        PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
//        while (resultSet.next()) {
        statement.setString(1, id);
        statement.setString(2, newObjectId);
        statement.setString(3, productAttrID.getProperty(attrType));
        statement.setString(4, value);
        statement.execute();
//        }
    }

    private void editProductAttribute(PreparedStatement statement, String value, String id, String key) throws SQLException{
        statement.setString(1,value);
        statement.setString(2,id);
        statement.setString(3,key);
        statement.execute();
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor = Exception.class)
    @Override
    public List<Product> getProductsBySuperCategory(String supercategory) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfTargetSuperCategory = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_OBJECT_ID_BY_ATTR_ID_AND_VALUE));
            statement.setString(1, productAttrID.getProperty("SUPERCATEGORY"));
            statement.setString(2, supercategory);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfTargetSuperCategory.add(getProductById(setOfTargetObjectIds.getString(1)));
            }

            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return productsOfTargetSuperCategory;
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor = Exception.class)
    @Override
    public List<Product> getProductsByOneParameter(String attribute, String val) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfTargetSuperCategory = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_OBJECT_ID_BY_ATTR_ID_AND_VALUE));
            statement.setString(1, productAttrID.getProperty(attribute));
            statement.setString(2, val);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfTargetSuperCategory.add(getProductById(setOfTargetObjectIds.getString(1)));
            }

            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return productsOfTargetSuperCategory;
    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor = Exception.class)
    @Override
    public List<Product> getProductsByTwoParameters(String attribute1, String val1, String attribute2, String val2) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfTargetSuperCategory = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_OBJECT_ID_BY_TWO_ATTR_ID_AND_VALUE));
            statement.setString(1, productAttrID.getProperty(attribute1));
            statement.setString(2, val1);
            statement.setString(3, productAttrID.getProperty(attribute2));
            statement.setString(4, val2);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfTargetSuperCategory.add(getProductById(setOfTargetObjectIds.getString(1)));
            }

            setOfTargetObjectIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return productsOfTargetSuperCategory;
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        ProductDaoImpl pDaoImpl = new ProductDaoImpl();
//        List<Product> lst;
//        lst = pDaoImpl.getAllProducts();
//        int i = 0;
//        if (lst != null) {
//            for (Product x : lst) {
//                System.out.println(i++ + ". " + x.toString());
//            }
//        } else {
//            System.out.println("Nothing to shown\n");
//        }
//        Product p = new Product();
//        p.setCategory("WOMEN_CLOTHING");
//        p.setSuperCategory("Fashion");
//        p.setOwner("TEST");
//        p.setCost("TEST");
//        p.setDescription("TEST");
//        p.setTitle("Блузка");
//        p.setPhone("TEST");
//        p.setPhoto("-1");
//        Map<String, String> map = new HashMap<>();
//        map.put("SIZE_", "TEST");
//        map.put("CONDITION", "TEST");
//        map.put("SEASONS", "TEST");
//        map.put("KIND_OF_CLOTHES", "TEST");
//        p.setAttributesAndValues(map);
//        pDaoImpl.addProduct(p);
//        lst = pDaoImpl.getAllProducts();
//
//        i = 0;
//        if (lst != null) {
//            for (Product x : lst) {
//                System.out.println(i++ + ". " + x.toString());
//            }
//        } else {
//            System.out.println("Nothing to shown\n");
//        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
//        Connection connection = poolInst.getConnection();
//        new ProductDaoImpl();
//        String s = productAttrID.getProperty("TITLE");
//        System.out.println("Asd");
//        System.out.println(productAttrID.getProperty("TITLE"));
    }

}