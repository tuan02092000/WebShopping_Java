package com.tuannv.DAO.Impl;

import com.tuannv.DAO.Interface.ICategoryDAO;
import com.tuannv.Database.ConnectDB;
import com.tuannv.Model.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryDAO implements ICategoryDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<CategoryModel> findAllCategory() {
        List<CategoryModel> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            String sql = "select * from category";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                CategoryModel category = new CategoryModel( resultSet.getInt("id"),resultSet.getString("name"));
                list.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public CategoryModel findCategoryById(int id) {
        try {
            connection = new ConnectDB().getConnection();
            String sql = "select  * from category where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new CategoryModel( resultSet.getInt("id"),resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        List<CategoryModel> listCategory = new ArrayList<>();
        CategoryDAO categoryDAO = new CategoryDAO();
        listCategory = categoryDAO.findAllCategory();
        for (CategoryModel list: listCategory) {
            System.out.println(list.toString());
        }
    }
}
