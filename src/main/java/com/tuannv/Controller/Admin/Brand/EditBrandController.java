package com.tuannv.Controller.Admin.Brand;

import com.tuannv.DAO.Impl.BrandDAO;
import com.tuannv.DAO.Impl.ProductDAO;
import com.tuannv.Model.BrandModel;
import com.tuannv.Model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/edit-brand"})
public class EditBrandController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BrandDAO brandDAO = new BrandDAO();
        BrandModel brand = brandDAO.findBrandById(id);
        request.setAttribute("brand", brand);

        request.getRequestDispatcher("/Manager/editBrand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("pid"));
        String name = request.getParameter("name");

        BrandModel brand = new BrandModel(id, name);
        BrandDAO brandDAO = new BrandDAO();

        if(brandDAO.editBrand(brand)){
            response.sendRedirect(request.getContextPath() + "/admin/show-brand?msg=success");
        }
        else{
            response.sendRedirect(request.getContextPath() +"/admin/show-brand?msg=fail");
        }
    }
}
