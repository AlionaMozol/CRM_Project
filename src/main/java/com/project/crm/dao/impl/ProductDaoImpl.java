package com.project.crm.dao.impl;


import com.project.crm.dao.DAO;
import com.project.crm.dao.ProductDao;
import com.project.crm.model.Product;
import com.project.crm.model.enums.Status;
import com.project.crm.services.SqlService;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


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
                   getProperty(SqlService.SQL_SELECT_TYPE_ID_BY_CATEGORY_AND_SUPERCATEGORY));
           statement.setString(1, product.getSuperCategory());
           statement.setString(2, product.getCategory());
           resultSet = statement.executeQuery();

           statement = connection.prepareStatement(sql.
                   getProperty(SqlService.SQL_INSERT_INTO_OBJECT));

           while(resultSet.next()) {
              newObjectTypeId = resultSet.getString(1);
           }
           String newObjectId = UUID.randomUUID().toString();
           statement.setString(1, newObjectId);
           statement.setString(2, newObjectTypeId);
           statement.execute();

           attributesAndValues = product.getAttributesAndValues();

           String attributesAttrId = null;
           String objectId = null;
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
                //добавляем запись с продуктом в таблицу
//                statement = connection.prepareStatement(sql.
//                        getProperty(SqlService.SQL_GET_OBJ_ID_BY_OBJ_TYPE_ID));
//                statement.setString(1, newObjectTypeId);
//                resultSet = statement.executeQuery();
//                while(resultSet.next()) {
//                   objectId = resultSet.getString(1);
//                }
                statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_ADD_OBJECT));
                statement.setString(1, UUID.randomUUID().toString());
                statement.setString(2, newObjectId);
                statement.setString(3, attributesAttrId);
                statement.setString(4, currentAttributeValue);
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
    public Product getProductById(String id) {
        Connection connection = poolInst.getConnection();
        Product currentProduct = new Product();
        currentProduct.setId(id);
        try {
            connection.setAutoCommit(false);
            String  currentObjectTypeId = null;
            PreparedStatement statement;
            ResultSet resultSet;
            //---------- Получаем Object.Object_type_id
            statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCT_BY_ID));
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                currentObjectTypeId = resultSet.getString(2);                //Object.Object_type_id
            }
            //---------- По Object.Object_type_id получаем категорию и суперкатегорию
            statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCT_TYPE_BY_ID));
            statement.setString(1, currentObjectTypeId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                currentProduct.setCategory(resultSet.getString(2));       //Категория
                currentProduct.setSuperCategory(resultSet.getString(3));  //Cуперкатегория
            }
            //----------
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_CATEGORIES_N_ATTRIBUTES));
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            Map<String, String> attributesAndValues = new HashMap<>();
            while(resultSet.next()) {
               attributesAndValues.put(resultSet.getString(1),
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

    // В БАЗЕ ЦЕНА ХРАНИТСЯ В ВИДЕ СТРОКИ, ПОЭТОМУ, ПОКА ЧТО, ЭТОТ МЕТОД ВОЗВРАЩАЕТ ПУСТОЙ СПИСОК !!!
    // КОГДА В БАЗЕ ЦЕНА БУДЕТ ХРАНИТЬСЯ В int, ТОГДА ВСЕ ДОЛЖНО РАБОТАТЬ !!!
    @Override
    public List<Product> getProductsBetween2Prices(int priceAfter, int priceBefore) {
        Connection connection = poolInst.getConnection();
        List<Product> productsOfTargetCost = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCTS_BETWEEN_2_PRICES));
            statement.setInt(1, priceAfter);
            statement.setInt(2, priceBefore);
            ResultSet setOfTargetObjectIds = statement.executeQuery();
            while (setOfTargetObjectIds.next()) {
                productsOfTargetCost.add(getProductById(setOfTargetObjectIds.getString(1)));
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
        return productsOfTargetCost;
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
        ProductDaoImpl d = new ProductDaoImpl();
//        Product p = new Product();
//        p.setSuperCategory("Technics");
//        p.setCategory("Телефоны");
//        Map<String, String> map = new HashMap<>();
//        map.put("Состояние","ТЕСТ");
//        map.put("Тип","ТЕСТ");
//        map.put("Марка","ТЕСТ");
//        map.put("Диагональ экрана","ТЕСТ");
//        map.put("Цена","ТЕСТ");
//        map.put("Пользователь","ТЕСТ");
//        p.setAttributesAndValues(map);
//        d.addProduct(p);
        System.out.println(d.getAllProducts());
    }

}
