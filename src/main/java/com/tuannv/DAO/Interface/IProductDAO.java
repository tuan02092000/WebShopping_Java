package com.tuannv.DAO.Interface;

import com.tuannv.Model.Product;
import com.tuannv.Model.ProductModel;

import java.util.List;

public interface IProductDAO {
    List<ProductModel> findALlProduct();
    List<ProductModel> findProductByBrandId(int id);
    List<ProductModel> findProductByText(String txt);
    List<Product> showAllProduct();
    ProductModel findProductById(int id);
    void deleteProduct(int id);
    boolean addProduct(ProductModel product);
    boolean editProduct(ProductModel product);
}
