package com.project.crm.junit;

import com.project.crm.dao.impl.ProductDaoImpl;
import com.project.crm.model.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit test class for {@link ProductDaoImpl}
 */
class productDaoImplTest {


    private ProductDaoImpl productDao = new ProductDaoImpl();


    @Test
    void getProductsByCategory() {
        Product product1 = new Product();
        Map<String, String> att1 = new HashMap<>();
        product1.setCost("10");
        product1.setOwner("user1");
        product1.setCategory("MEN_SHOES");
        product1.setSuperCategory("Fashion");
        product1.setTitle("Кеды");
        product1.setAttributesAndValues(att1);

        Product product2 = new Product();
        Map<String, String> att2 = new HashMap<>();
        product2.setCost("30");
        product2.setOwner("user2");
        product2.setCategory("MEN_SHOES");
        product2.setSuperCategory("Fashion");
        product2.setTitle("Туфли");
        product2.setAttributesAndValues(att2);

        productDao.addProduct(product2);
        List<Product> productList;
        //productList = productDao.getProductsByCategory("MEN_SHOES");
        productList = productDao.getProductsByOneParameter("CATEGORY","MEN_SHOES");
        for (Product eachProduct : productList) {
            assertEquals("MEN_SHOES", eachProduct.getCategory());
        }
    }


}