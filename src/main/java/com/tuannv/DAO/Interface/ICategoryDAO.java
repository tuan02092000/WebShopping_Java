package com.tuannv.DAO.Interface;

import com.tuannv.Model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAllCategory();
    CategoryModel findCategoryById(int id);
}
