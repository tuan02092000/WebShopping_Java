package com.tuannv.Controller.Admin.Brand;

import com.tuannv.DAO.Impl.BrandDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/delete-brand"})
public class DeleteBrandController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        BrandDAO brandDAO = new BrandDAO();
        if(brandDAO.deleteBrandById(id)){
            response.sendRedirect(request.getContextPath() +"/admin/show-brand?msg=deleteSuccess");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
