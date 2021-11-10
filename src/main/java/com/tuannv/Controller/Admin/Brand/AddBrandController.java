package com.tuannv.Controller.Admin.Brand;

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

@WebServlet(urlPatterns = {"/admin/add-brand"})
public class AddBrandController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("/Manager/addBrand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");

        BrandModel brand = new BrandModel(name);
        BrandDAO brandDAO = new BrandDAO();

        if(brandDAO.addBrand(brand)){
            response.sendRedirect(request.getContextPath() + "/admin/add-brand?msg=success");
        }
        else{
            response.sendRedirect(request.getContextPath() + "/admin/add-brand?msg=fail");
        }
    }
}
