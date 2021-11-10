package com.tuannv.DAO.Admin.Interface;

import com.tuannv.Model.ProductModel;

import java.util.List;

public interface IShowProductDAO {
    List<ProductModel> findAllProduct();
}
