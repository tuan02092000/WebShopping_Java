package com.tuannv.DAO.Impl;

import com.tuannv.DAO.Interface.ILoginDAO;
import com.tuannv.Database.ConnectDB;
import com.tuannv.Model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO implements ILoginDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public UserModel findUser(String userName, String password) {
        try {
            connection = new ConnectDB().getConnection();
            String sql = "select * from user where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("fullname"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("address"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                user.setIsCustomer(resultSet.getInt("isCustomer"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        LoginDAO loginDAO = new LoginDAO();
        UserModel user = loginDAO.findUser("tuannv", "123456");
        System.out.println(user.toString());
    }
}
