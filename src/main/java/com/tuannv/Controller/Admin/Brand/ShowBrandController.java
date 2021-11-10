package com.tuannv.Controller.Admin.Brand;

import com.tuannv.DAO.Impl.BrandDAO;
import com.tuannv.Model.BrandModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/show-brand"})
public class ShowBrandController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandDAO brandDAO = new BrandDAO();
        List<BrandModel> listBrand = brandDAO.findAllBrand();
        request.setAttribute("listBrand", listBrand);
        request.getRequestDispatcher("/Manager/showBrand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
