package com.project.crm.dao.impl;

import com.project.crm.dao.AttributeDao;
import com.project.crm.dao.DAO;
import com.project.crm.services.SqlService;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AttributeDaoImpl extends DAO implements AttributeDao {


    @Override
    public List<String> getAttributesByCategory(String category) {
        Connection connection = poolInst.getConnection();
        List<String> attributesOfTargetCategory = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_ATTRIBUTES_BY_CATEGORY));
            statement.setString(1, category);
            ResultSet setOfAttributes = statement.executeQuery();
            while (setOfAttributes.next()) {
                attributesOfTargetCategory.add(setOfAttributes.getString(1));
            }
            setOfAttributes.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);
        } finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }
        return attributesOfTargetCategory;
    }

    private void tryToRollbackConnection(Connection connection) {
        try {
            connection.rollback();
            System.err.print("Transaction is being rolled back!");
        } catch (SQLException e) {
            System.err.print("Transaction is NOT being rolled back!");
            e.printStackTrace();
        }
    }

    private void tryToSetAutoCommitTrueForConnection(Connection connection) {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}