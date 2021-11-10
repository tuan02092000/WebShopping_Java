package com.tuannv.Controller;

import com.tuannv.DAO.Impl.BrandDAO;
import com.tuannv.DAO.Impl.CategoryDAO;
import com.tuannv.DAO.Impl.ProductDAO;
import com.tuannv.DAO.PagingDAO;
import com.tuannv.Model.BrandModel;
import com.tuannv.Model.CategoryModel;
import com.tuannv.Model.Product;
import com.tuannv.Model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/home", name = "home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

//        ProductDAO productDAO = new ProductDAO();
//        List<ProductModel> listProduct = productDAO.findALlProduct();
//        request.setAttribute("listProduct", listProduct);

        CategoryDAO categoryDAO = new CategoryDAO();
        List<CategoryModel> listCategory = categoryDAO.findAllCategory();
        request.setAttribute("listCategory", listCategory);

        BrandDAO brandDAO = new BrandDAO();
        List<BrandModel> listBrand = brandDAO.findAllBrand();
        request.setAttribute("listBrand", listBrand);

        PagingDAO pagingDAO = new PagingDAO();
        int totalRecord = pagingDAO.getTotalRecord();
        int currentPage = (request.getParameter("index") != null)?(Integer.parseInt(request.getParameter("index"))):1;
        int limit = 6;
        int totalPage = 0;
        if(totalRecord % limit == 0){
            totalPage = totalRecord / limit;
        }else {
            totalPage = totalRecord / limit + 1;
        }
        if(currentPage > totalPage){
            currentPage = totalPage;
        }else if(currentPage < 1){
            currentPage = 1;
        }

        int start = (currentPage - 1)*limit;

        List<Product> list = pagingDAO.showAnyProduct(start, limit);

        request.setAttribute("listProduct", list);
        request.setAttribute("totalPage", totalPage);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }
}
