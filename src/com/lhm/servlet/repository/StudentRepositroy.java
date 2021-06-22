package com.lhm.servlet.repository;

import com.lhm.servlet.entity.Student;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentRepositroy {
    public List<Student> findAll(){
        //提出来扩大作用域，用于释放资源时关闭
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;

        List<Student> list = new ArrayList<>();
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取数据库连接
            String url = "jdbc:mysql://localhost:3306/myjavawork?serverTimezone=PRC";//连接的库
            String user = "root";//数据库用户名和密码
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);
            //查询
            String sqlc = "select * from Student";
            preparedStatement = connection.prepareStatement(sqlc);
           resultSet = preparedStatement.executeQuery();
           //通过循环将数据库数据取出来
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer age = resultSet.getInt(3);
                student = new Student(id,name,age);
                list.add(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            //关闭，释放资源
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
