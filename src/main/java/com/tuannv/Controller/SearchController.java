package com.tuannv.Controller;

import com.tuannv.DAO.Impl.BrandDAO;
import com.tuannv.DAO.Impl.CategoryDAO;
import com.tuannv.DAO.Impl.ProductDAO;
import com.tuannv.Model.BrandModel;
import com.tuannv.Model.CategoryModel;
import com.tuannv.Model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String txt = request.getParameter("txt");
        ProductDAO productDAO = new ProductDAO();
        List<ProductModel> listProduct = productDAO.findProductByText(txt);
        request.setAttribute("listProduct", listProduct);

        CategoryDAO categoryDAO = new CategoryDAO();
        List<CategoryModel> listCategory = categoryDAO.findAllCategory();
        request.setAttribute("listCategory", listCategory);

        BrandDAO brandDAO = new BrandDAO();
        List<BrandModel> listBrand = brandDAO.findAllBrand();
        request.setAttribute("listBrand", listBrand);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }
}
