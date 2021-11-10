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

@WebServlet(value = "/edit-product", name = "editProduct")
public class EditProductController extends HttpServlet {
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


        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        ProductModel product = productDAO.findProductById(id);
        request.setAttribute("product", product);

        request.getRequestDispatcher("Manager/editProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("pid"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int brandId = Integer.parseInt(request.getParameter("brand"));
        ProductModel product = new ProductModel(id, name, image, price, categoryId, brandId);
        ProductDAO productDAO = new ProductDAO();

        if(productDAO.editProduct(product)){
            response.sendRedirect("show-product?msg=success");
        }
        else{
            response.sendRedirect("show-product?msg=fail");
        }
    }
}
