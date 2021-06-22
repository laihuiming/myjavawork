package com.lhm.servlet.servlet;

import com.lhm.servlet.entity.Student;
import com.lhm.servlet.repository.StudentRepositroy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //返回视图和数据
        StudentRepositroy studentRepositroy = new StudentRepositroy();
        List<Student> list= studentRepositroy.findAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
