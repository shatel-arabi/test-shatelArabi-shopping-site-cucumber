package com.swaglabs.helpers.utils;

import com.swaglabs.helpers.EnvironmentUtils;

import java.sql.*;

public class DbUtils {
    //Oracle connections
    public static Connection connection() {
        Connection connection = null;
        String url = EnvironmentUtils.getEnvironmentProperties("db.url");
        String dbUsername = EnvironmentUtils.getEnvironmentProperties("db.username");
        String dbPassword = EnvironmentUtils.getEnvironmentProperties("db.password");
        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create DB connection.\n" + e);
        }
        return connection;
    }

    public static ResultSet executeSelect(Connection connection, String selectQuery) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(selectQuery);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to close DB connection.\n" + e);
            }
        }
    }
}
