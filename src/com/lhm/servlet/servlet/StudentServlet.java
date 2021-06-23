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
//        StudentRepositroy studentRepositroy = new StudentRepositroy();
//        Integer page = Integer.parseInt(req.getParameter("page"));
//        Integer rows = Integer.parseInt(req.getParameter("rows"));
//        List<Student> list= studentRepositroy.findStudentByPage(page,rows);
//        req.setAttribute("list",list);
//        req.getRequestDispatcher("index.jsp").forward(req,resp);


        String method = req.getParameter("method");
        if (method == null) {
            method = "findStudentByPage";
        }
        switch (method) {
            case "deleteById":
                //删除并再跳转回列表
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                StudentRepositroy.deleteById(id);
                resp.setContentType("text/html;charset=UTF-8");
                resp.sendRedirect("/work/student?page=1&rows=5");
                break;
            case "findStudentByPage":
                StudentRepositroy studentRepositroy = new StudentRepositroy();
                Integer page = Integer.parseInt(req.getParameter("page"));
                Integer rows = Integer.parseInt(req.getParameter("rows"));
                List<Student> list = studentRepositroy.findStudentByPage(page, rows);
                req.setAttribute("list", list);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String method = req.getParameter("method");
        switch (method) {
            case "update":
                //修改
                try {
                    req.setCharacterEncoding("UTF-8");
                    String idStr = req.getParameter("id");
                    Integer id = Integer.parseInt(idStr);
                    String name = req.getParameter("name");
                    String ageStr = req.getParameter("age");
                    Integer age = Integer.parseInt(ageStr);
                    StudentRepositroy.update(id, name, age);
                    System.out.println("执行了id=" + id + "行的修改操作");
                    System.out.println("name = " + name);
                    System.out.println("age = " + age);
                    resp.setContentType("text/html;charset=UTF-8");
                } catch (NumberFormatException e) {
                    e.getStackTrace();
                }
                break;
            case "findStudentByPage1":
                StudentRepositroy studentRepositroy = new StudentRepositroy();
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                List<Student> list = studentRepositroy.findStudentByPage(page, 5);
                req.setAttribute("list", list);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect("/work/student?page=1&rows=5");
    }
}
