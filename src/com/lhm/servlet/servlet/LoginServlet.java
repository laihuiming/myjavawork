package com.lhm.servlet.servlet;

import com.lhm.servlet.repository.UserRepositroy;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserRepositroy userRepositroy = new UserRepositroy();
        if (userRepositroy.checklogin(username,password)){

            System.out.println("登录成功");
            resp.sendRedirect("/work/student?page=1&rows=5");
        }else{
            System.out.println("登录失败");
            resp.sendRedirect("/work/login.jsp");
        }
    }
}
