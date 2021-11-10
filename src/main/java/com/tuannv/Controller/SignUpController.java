package com.tuannv.Controller;

import com.tuannv.DAO.Impl.SignUpDAO;
import com.tuannv.Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignUpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rePass = request.getParameter("rePassword");
        String email = request.getParameter("email");

        SignUpDAO signUpDAO = new SignUpDAO();
        UserModel user = new UserModel(userName, password, email);

        if(!password.equals(rePass)){
            response.sendRedirect("login.jsp?msg=passNotMatch");
        }else if(signUpDAO.checkAccountExist(userName)){
            response.sendRedirect("login.jsp?msg=userNameWasExist");
        }else if(signUpDAO.signUp(user)){
            response.sendRedirect("login.jsp?msg=success");
        }else{
            response.sendRedirect("login.jsp?msg=invalid");
        }
    }
}
