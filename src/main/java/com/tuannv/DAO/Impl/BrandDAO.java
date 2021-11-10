package com.tuannv.DAO.Impl;

import com.tuannv.DAO.Interface.IBrandDAO;
import com.tuannv.Database.ConnectDB;
import com.tuannv.Model.BrandModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO implements IBrandDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<BrandModel> findAllBrand() {
        List<BrandModel> listBrand = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            String sql = "select *, (select count(*) from product as p where p.brand_id = b.id) as total from brand as b";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                BrandModel brandModel = new BrandModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("total"));
                listBrand.add(brandModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBrand;
    }

    @Override
    public BrandModel findBrandById(int id) {
        BrandModel brand = null;
        try {
            connection = new ConnectDB().getConnection();
            String sql = "select  * from brand where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                brand = new BrandModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
            return brand;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brand;
    }

    @Override
    public boolean deleteBrandById(int id) {
        boolean rs = false;
        try {
            connection = new ConnectDB().getConnection();
            String sql = "delete from brand where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            if(result > 0) rs = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean addBrand(BrandModel brand) {
        boolean rs = false;
        try {
            connection = new ConnectDB().getConnection();
            String sql = "insert into brand (name)" +
                    "values (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, brand.getName());
            int result = preparedStatement.executeUpdate();
            if(result > 0) rs = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean editBrand(BrandModel brand) {
        boolean rs = false;
        try {
            connection = new ConnectDB().getConnection();
            String sql = "update brand set name = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, brand.getName());
            preparedStatement.setInt(2, brand.getId());
            int result = preparedStatement.executeUpdate();
            if(result > 0) rs = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void main(String[] args) {
        List<BrandModel> list = new ArrayList<>();
        BrandDAO brandDAO = new BrandDAO();
        list = brandDAO.findAllBrand();
        for (BrandModel b: list
             ) {
            System.out.println(b.toString());
        }
    }
}
