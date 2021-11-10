package com.tuannv.DAO.Interface;

import com.tuannv.Model.BrandModel;
import com.tuannv.Model.ProductModel;

import java.util.List;

public interface IBrandDAO {
    List<BrandModel> findAllBrand();
    BrandModel findBrandById(int id);
    boolean deleteBrandById(int id);
    boolean addBrand(BrandModel brand);
    boolean editBrand(BrandModel brand);
}
