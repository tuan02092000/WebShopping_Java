package com.tuannv.Database;

import com.tuannv.AppConfig.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection connection = null;
    public void driverTest() throws ClassNotFoundException {
        try {
            Class.forName(DB.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("JDBC DRIVER NOT FOUND" + e.getMessage());
        }
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){
            driverTest();
            try {
                connection = DriverManager.getConnection(DB.URL_DATABASE, DB.USER_NAME, DB.PASSWORD);
                System.out.println("Connect DataBase Successfully!!!");
            } catch (SQLException throwables) {
                throw new SQLException("Connect DataBase Fail!!!" + throwables.getMessage());
            }
        }
        return connection;
    }
    public void closeConnection() throws SQLException {
        if(connection != null){
            connection.close();
            System.out.println("Disconnect DataBase");
        }
    }
}
