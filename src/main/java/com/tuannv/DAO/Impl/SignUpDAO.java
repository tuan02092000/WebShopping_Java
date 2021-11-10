package com.tuannv.DAO.Impl;

import com.tuannv.DAO.Interface.ISignUpDAO;
import com.tuannv.Database.ConnectDB;
import com.tuannv.Model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpDAO implements ISignUpDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public boolean signUp(UserModel user) {
        boolean rs = false;
        try {
            connection = new ConnectDB().getConnection();
            String sql = "insert into user (id, username, password, email, fullname, age, address, isAdmin, isCustomer) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getFullName());
            preparedStatement.setInt(6, user.getAge());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setInt(8, user.getIsAdmin());
            preparedStatement.setInt(9, user.getIsCustomer());
            int result = preparedStatement.executeUpdate();
            if(result > 0) rs = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean checkAccountExist(String userName) {
        try {
            connection = new ConnectDB().getConnection();
            String sql = "select * from user where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
