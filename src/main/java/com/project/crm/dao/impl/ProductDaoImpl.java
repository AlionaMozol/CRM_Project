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
           int newObjectTypeId = 0;
           Map<String, String> attributesAndValues;

           statement = connection.prepareStatement(sql.
                   getProperty(SqlService.SQL_SELECT_TYPE_ID_BY_CATEGORY_AND_SUPERCATEGORY));
           statement.setString(1, product.getSuperCategory());
           statement.setString(2, product.getCategory());
           resultSet = statement.executeQuery();

           statement = connection.prepareStatement(sql.
                   getProperty(SqlService.SQL_INSERT_INTO_OBJECT));

           while(resultSet.next()) {
              newObjectTypeId = resultSet.getInt(1);
           }
           statement.setInt(1, newObjectTypeId);
           statement.execute();

           attributesAndValues = product.getAttributesAndValues();

           int attributesAttrId = 0;
           int objectId = 0;
           for (Map.Entry entry: attributesAndValues.entrySet()) {
                //Получаем атрибуты и их значения
                String currentAttribute = (String) entry.getKey();
                String currentAttributeValue = (String) entry.getValue();
                //Получаем подходящий attr_id
                statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_SELECT_NECESSARY_ATTR_ID));
                statement.setInt(1, newObjectTypeId);
                statement.setString(2, currentAttribute);
                ResultSet attributesAttrIdSet = statement.executeQuery();
                while(attributesAttrIdSet.next()) {
                    attributesAttrId = attributesAttrIdSet.getInt(1);
                }
                //добавляем запись с продуктом в таблицу
                statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_GET_OBJ_ID_BY_OBJ_TYPE_ID));
                statement.setInt(1, newObjectTypeId);
                resultSet = statement.executeQuery();
                while(resultSet.next()) {
                   objectId = resultSet.getInt(1);
                }

                statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_ADD_OBJECT));
                statement.setInt(1, objectId);
                statement.setInt(2, attributesAttrId);
                statement.setString(3, currentAttributeValue);
                statement.execute();
           }

           statement.close();
           resultSet.close();
           connection.commit();
        } catch (SQLException e) {
            try {
                System.err.print("Transaction is being rolled back");
                connection.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            poolInst.footConnection(connection);
        }
    }

    @Override
    public Product getProductById(int id) {
        Connection connection = poolInst.getConnection();
        Product currentProduct = new Product();
        currentProduct.setId(id);
        try {
            connection.setAutoCommit(false);
            int currentObjectTypeId = 0;
            PreparedStatement statement;
            ResultSet resultSet;
            //---------- Получаем Object.Object_type_id
            statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCT_BY_ID));
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                currentObjectTypeId = resultSet.getInt(2);                //Object.Object_type_id
            }
            //---------- По Object.Object_type_id получаем категорию и суперкатегорию
            statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCT_TYPE_BY_ID));
            statement.setInt(1, currentObjectTypeId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                currentProduct.setCategory(resultSet.getString(2));       //Категория
                currentProduct.setSuperCategory(resultSet.getString(3));  //Cуперкатегория
            }
            //----------
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_CATEGORIES_N_ATTRIBUTES));
            statement.setInt(1, id);
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
            try {
                System.err.print("Transaction is being rolled back");
                connection.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
                productsOfTargetCategory.add(getProductById(setOfTargetObjectIds.getInt(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            try {
                System.err.print("Transaction is being rolled back");
                connection.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
                productsOfTargetCost.add(getProductById(setOfTargetObjectIds.getInt(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            try {
                System.err.print("Transaction is being rolled back");
                connection.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
                allProducts.add(getProductById(setOfTargetObjectIds.getInt(1)));
            }
            setOfTargetObjectIds.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            try {
                System.err.print("Transaction is being rolled back");
                connection.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            poolInst.footConnection(connection);
        }
        return allProducts;
    }

    @Override
    public void deleteProductById(int id) {
        Connection connection = poolInst.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement;
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_DELETE_VALUES_BY_OBJECT_ID));
            statement.setInt(1, id);
            statement.execute();

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_DELETE_OBJECT_BY_ID));
            statement.setInt(1, id);
            statement.execute();

            statement.close();
            connection.commit();
        } catch (SQLException e) {
            try {
                System.err.print("Transaction is being rolled back");
                connection.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            poolInst.footConnection(connection);
        }
    }


  /*     public static void main(String[] args) throws ClassNotFoundException {
            ProductDaoImpl d = new ProductDaoImpl();
              Product p = new Product();
              List<Product> products;
            products = d.getAllProducts();
            System.out.println(products.get(10).getId());
//              p.setSuperCategory("Техника");
//              p.setCategory("Телефоны");
//              Map<String, String> map = new HashMap<>();
//              map.put("Состояние","ТЕСТ");
//              map.put("Тип","ТЕСТ");
//              map.put("Марка","ТЕСТ");
//              map.put("Диагональ экрана","ТЕСТ");
//              map.put("Цена","ТЕСТ");
//              map.put("Пользователь","ТЕСТ");
//              p.setAttributesAndValues(map);
//              d.addProduct(p);
          }*/

}
