package com.tuannv.Controller.Admin.Product;

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

@WebServlet( value = "/add-product", name = "addProduct")
public class AddProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        CategoryDAO categoryDAO = new CategoryDAO();
        List<CategoryModel> listCategory = categoryDAO.findAllCategory();
        request.setAttribute("listCategory", listCategory);

        BrandDAO brandDAO = new BrandDAO();
        List<BrandModel> listBrand = brandDAO.findAllBrand();
        request.setAttribute("listBrand", listBrand);

        request.getRequestDispatcher("Manager/addProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int brandId = Integer.parseInt(request.getParameter("brand"));
        ProductModel product = new ProductModel(name, image, price, categoryId, brandId);
        ProductDAO productDAO = new ProductDAO();

        if(productDAO.addProduct(product)){
           response.sendRedirect("add-product?msg=success");
        }
        else{
            response.sendRedirect("add-product?msg=fail");
        }
    }
}
