package com.tuannv.DAO.Admin.Impl;

import com.tuannv.DAO.Admin.Interface.IShowProductDAO;
import com.tuannv.Database.ConnectDB;
import com.tuannv.Model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowProductDAO implements IShowProductDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<ProductModel> findAllProduct() {
        List<ProductModel> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            String sql = "select * from product";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ProductModel product = new ProductModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("image"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("brand_id"));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
