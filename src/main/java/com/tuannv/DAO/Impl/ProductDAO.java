package com.tuannv.DAO.Impl;

import com.tuannv.DAO.Interface.IProductDAO;
import com.tuannv.Database.ConnectDB;
import com.tuannv.Model.BrandModel;
import com.tuannv.Model.CategoryModel;
import com.tuannv.Model.Product;
import com.tuannv.Model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    Connection con= null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<ProductModel> findALlProduct(){
        List<ProductModel> list = new ArrayList<>();
        try {
            con = new ConnectDB().getConnection();
            String sql = "select * from product";
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ProductModel productModel = new ProductModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("image"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("brand_id"));
                list.add(productModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> showAllProduct(){
        List<Product> list = new ArrayList<>();
        BrandDAO brandDAO = new BrandDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        try{
            con = new ConnectDB().getConnection();
            String sql = "select * from product";
            preparedStatement = con.prepareStatement(sql);
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

    @Override
    public List<ProductModel> findProductByBrandId(int id) {
        List<ProductModel> list= new ArrayList<>();

        try {
            con = new ConnectDB().getConnection();
            String sql = "select  * from product where brand_id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ProductModel productModel = new ProductModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("image"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("brand_id"));
                list.add(productModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<ProductModel> findProductByText(String txt) {
        List<ProductModel> list= new ArrayList<>();

        try {
            con = new ConnectDB().getConnection();
            String sql = "select  * from product where name like ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + txt + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ProductModel productModel = new ProductModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("image"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("brand_id"));
                list.add(productModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ProductModel findProductById(int id) {
        try {
            con = new ConnectDB().getConnection();
            String sql = "select * from product where id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new ProductModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("image"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("brand_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteProduct(int id) {
        try {
            con = new ConnectDB().getConnection();
            String sql = "delete from product where id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addProduct(ProductModel product) {
        boolean rs = false;
        try {
            con = new ConnectDB().getConnection();
            String sql = "insert into product (name, price, image, category_id, brand_id)" +
                    "values (?, ?, ?, ? ,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setInt(4, product.getCategoryId());
            preparedStatement.setInt(5, product.getBrandId());
            int result = preparedStatement.executeUpdate();
            if(result > 0) rs = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean editProduct(ProductModel product) {
        boolean rs = false;
        try {
            con = new ConnectDB().getConnection();
            String sql = "update product set name = ?," +
                    "price = ?,\n" +
                    " image = ?, \n" +
                    " category_id = ?,\n" +
                    " brand_id = ? \n" +
                    " where id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setInt(4, product.getCategoryId());
            preparedStatement.setInt(5, product.getBrandId());
            preparedStatement.setInt(6, product.getId());
            int result = preparedStatement.executeUpdate();
            if(result > 0) rs = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        List<ProductModel> list = new ArrayList<>();
        list = productDAO.findProductByText("Polo");
        for (ProductModel l: list) {
            System.out.println(l.toString());
        }
    }
}
