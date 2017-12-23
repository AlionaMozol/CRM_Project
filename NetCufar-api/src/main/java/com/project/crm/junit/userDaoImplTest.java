package com.project.crm.junit;

import com.project.crm.dao.impl.UserDaoImpl;
import com.project.crm.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by 1 on 02.12.2017.
 */
class userDaoImplTest {

    @Test
    void getUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setFio("user1");
        user.setSex("Ж");
        user.setCity("minsk");
        user.setStatus("2");
        user.setAccountCreationDate("25.12.2008");
        user.setRating("1");
        user.setId(111);
        user.setTelephone("80298285183");
        user.setDateOfBirth("11.11.1997");
        user.setEmail("ankabrest@mail.ru");
        userDao.addUser(user);
        assertEquals(user.getFio(), userDao.getUserById(111).getFio());
    }
}
