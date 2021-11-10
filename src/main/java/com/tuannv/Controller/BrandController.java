package com.tuannv.Controller;

import com.tuannv.DAO.Impl.BrandDAO;
import com.tuannv.DAO.Impl.CategoryDAO;
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

import static java.lang.Math.ceil;

@WebServlet("/brand")
public class BrandController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
