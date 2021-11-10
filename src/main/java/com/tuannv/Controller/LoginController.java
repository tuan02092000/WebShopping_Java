package com.tuannv.Controller;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.tuannv.DAO.Impl.LoginDAO;
import com.tuannv.Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/login", name = "login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie arr[] = request.getCookies();
        if(arr != null){
            for (Cookie o: arr) {
                if(o.getName().equals("username")){
                    request.setAttribute("username", o.getValue());
                }
                if(o.getName().equals("password")){
                    request.setAttribute("password", o.getValue());
                }
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        LoginDAO loginDAO = new LoginDAO();
        UserModel user = loginDAO.findUser(userName, password);

        if(user == null){
            response.sendRedirect("login?msg=incorrect");
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            Cookie cookie1 = new Cookie("username", userName);
            cookie1.setMaxAge(120);
            response.addCookie(cookie1);

            Cookie cookie2 = new Cookie("password", password);
            if(remember != null){
                cookie2.setMaxAge(120);
            }else{
                cookie2.setMaxAge(0);
            }
            response.addCookie(cookie2);

            if(user.getIsAdmin() == 1){
                response.sendRedirect("show-product");
            }else{
                response.sendRedirect("home");
            }
        }
    }
}
