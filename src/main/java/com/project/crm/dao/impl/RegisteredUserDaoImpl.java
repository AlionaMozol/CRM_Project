package com.project.crm.dao.impl;

import com.project.crm.dao.DAO;
import com.project.crm.dao.RegisteredUserDao;
import com.project.crm.model.RegisteredUser;
import com.project.crm.model.User;
import com.project.crm.services.SqlService;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 09.11.2017.
 */
public class RegisteredUserDaoImpl extends DAO implements RegisteredUserDao {


    String SQL_SELECT_BY_CATYGORY="SELECT * FROM spring_security_app.object_type WHERE Value = ?";
    String SQL_INSERT_OBJECT="INSERT INTO spring_security_app.object VALUES(DEFAULT , ?)";
    String SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR=" SELECT attr_id FROM spring_security_app.attributes WHERE Object_type_id = ? AND Value = ?";
    String SQL_SELECT_BY_OBJECT_TYPE_ID_FROM_OBJECT="SELECT * FROM spring_security_app.object WHERE Object_type_id = ?";
    String SQL_INSERT_VALUE=" INSERT INTO spring_security_app.values VALUES(default, ?, ? ,?)";

    @Override
    public void addRegisteredUserDao(RegisteredUser registeredUser) {
        Connection connection = poolInst.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_CATYGORY);
            statement.setString(1,"Пользователь");
            ResultSet resultSet = statement.executeQuery();
            int objectTypeId=0;
            int attrId=0;
            int objectId=0;

            statement = connection.prepareStatement(SQL_INSERT_OBJECT);

            if(resultSet.next()){
                objectTypeId=resultSet.getInt(1);
                statement.setInt(1, objectTypeId);
            }
            statement.execute();

            ////////////////id///////////////
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"ID");
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                attrId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_FROM_OBJECT);
            statement.setInt(1,objectTypeId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                objectId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_INSERT_VALUE);

            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            statement.setInt(3,registeredUser.getId());
            statement.execute();

            ////////////////fio///////////////
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"ФИО");
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                attrId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_FROM_OBJECT);
            statement.setInt(1,objectTypeId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                objectId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_INSERT_VALUE);

            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            statement.setString(3,registeredUser.getFio());
            statement.execute();
            ////////////////телефон///////////////
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Телефон");
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                attrId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_FROM_OBJECT);
            statement.setInt(1,objectTypeId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                objectId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_INSERT_VALUE);

            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            statement.setString(3,registeredUser.getTelephone());
            statement.execute();
            ////////////////email///////////////
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Электронная почта");
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                attrId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_FROM_OBJECT);
            statement.setInt(1,objectTypeId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                objectId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_INSERT_VALUE);

            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            statement.setInt(3,registeredUser.getId());
            statement.execute();
            ////////////////Дата рождения///////////////
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Дата рождения");
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                attrId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_FROM_OBJECT);
            statement.setInt(1,objectTypeId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                objectId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_INSERT_VALUE);

            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            statement.setString(3,registeredUser.getDateOfBith());
            statement.execute();
            ////////////////Местоположение///////////////
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Местоположение");
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                attrId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_FROM_OBJECT);
            statement.setInt(1,objectTypeId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                objectId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_INSERT_VALUE);

            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            statement.setInt(3,registeredUser.getId());
            statement.execute();
            ////////////////Пол///////////////
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Пол");
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                attrId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_FROM_OBJECT);
            statement.setInt(1,objectTypeId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                objectId=resultSet.getInt(1);
            }
            statement = connection.prepareStatement(SQL_INSERT_VALUE);

            System.out.println(objectId+" "+attrId+" "+ registeredUser.getId());
            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            statement.setString(3,registeredUser.getSex());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);

    }




    @Override
    public RegisteredUser getRegisteredUserById(int id) {
        Connection connection = poolInst.getConnection();
        RegisteredUser registeredUser = new RegisteredUser();
        try {

            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_CATYGORY);
            statement.setString(1,"Пользователь");
            ResultSet resultSet = statement.executeQuery();
            int objectTypeId=0;
            int attrId=0;
            int objectId=0;

            if(resultSet.next()){
                objectTypeId=resultSet.getInt(1);

            }

            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"ID");
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                attrId=resultSet.getInt(1);

            }
            statement = connection.prepareStatement("SELECT * FROM spring_security_app.values WHERE Attributes_attr_id = ? AND Value = ?");
            statement.setInt(1,attrId);
            statement.setInt(2,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                objectId=resultSet.getInt(2);

            }


            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"ФИО");
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                attrId=resultSet.getInt(1);

            }

            statement = connection.prepareStatement("SELECT * FROM spring_security_app.values WHERE Object_id = ? AND Attributes_attr_id = ? ");
            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            resultSet = statement.executeQuery();
            if(resultSet.next())
                registeredUser.setFio(resultSet.getString(4));




            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Телефон");
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                attrId=resultSet.getInt(1);

            }

            statement = connection.prepareStatement("SELECT * FROM spring_security_app.values WHERE Object_id = ? AND Attributes_attr_id = ? ");
            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            resultSet = statement.executeQuery();
            if(resultSet.next())
                registeredUser.setTelephone(resultSet.getString(4));



            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Электронный адрес");
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                attrId=resultSet.getInt(1);

            }
            statement = connection.prepareStatement("SELECT * FROM spring_security_app.values WHERE Object_id = ? AND Attributes_attr_id = ? ");
            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            resultSet = statement.executeQuery();
            if(resultSet.next())
                registeredUser.setEmail(resultSet.getString(4));



            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Пол");
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                attrId=resultSet.getInt(1);

            }
            statement = connection.prepareStatement("SELECT * FROM spring_security_app.values WHERE Object_id = ? AND Attributes_attr_id = ? ");
            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            resultSet = statement.executeQuery();
            if(resultSet.next())
                registeredUser.setSex(resultSet.getString(4));



            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Дата рождения");
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                attrId=resultSet.getInt(1);

            }
            statement = connection.prepareStatement("SELECT * FROM spring_security_app.values WHERE Object_id = ? AND Attributes_attr_id = ? ");
            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            resultSet = statement.executeQuery();
            if(resultSet.next())
                registeredUser.setDateOfBith(resultSet.getString(4));


            statement = connection.prepareStatement(SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR);
            statement.setInt(1,objectTypeId);
            statement.setString(2,"Местоположение");
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                attrId=resultSet.getInt(1);

            }
            statement = connection.prepareStatement("SELECT * FROM spring_security_app.values WHERE Object_id = ? AND Attributes_attr_id = ? ");
            statement.setInt(1,objectId);
            statement.setInt(2,attrId);
            resultSet = statement.executeQuery();
            if(resultSet.next())
                registeredUser.setCity(resultSet.getString(4));



        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);
        return registeredUser;
    }
}
