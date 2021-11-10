package com.tuannv.DAO;

import com.tuannv.DAO.Impl.BrandDAO;
import com.tuannv.DAO.Impl.CategoryDAO;
import com.tuannv.Database.ConnectDB;
import com.tuannv.Model.BrandModel;
import com.tuannv.Model.CategoryModel;
import com.tuannv.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagingDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public int getTotalRecord(){
        try {
            connection = new ConnectDB().getConnection();
            String sql = "select count(*) from product";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Product> showAnyProduct(int start, int limit){
        List<Product> list = new ArrayList<>();
        BrandDAO brandDAO = new BrandDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        try{
            connection = new ConnectDB().getConnection();
            String sql = "select * from product limit ?,?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, limit);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                BrandModel brand = brandDAO.findBrandById(resultSet.getInt("brand_id"));
                CategoryModel category = categoryDAO.findCategoryById(resultSet.getInt("category_id"));
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("image"),
                        resultSet.getDouble("price"),
                        category,
                        brand);
                list.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
