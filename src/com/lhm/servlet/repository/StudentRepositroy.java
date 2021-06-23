package com.lhm.servlet.repository;

import com.lhm.servlet.Util.DBUtil;
import com.lhm.servlet.entity.Student;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
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
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //获取数据库连接
//            String url = "jdbc:mysql://localhost:3306/myjavawork?serverTimezone=PRC";//连接的库
//            String user = "root";//数据库用户名和密码
//            String password = "123456";
            connection = DBUtil.getConnection();
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
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            //关闭，释放资源
//            try {
//                connection.close();
//                preparedStatement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            DBUtil.close(preparedStatement,connection);
        }
        return list;
    }

    public List<Student> findStudentByPage(int page, int rows){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        page = (page-1)*rows;
        List<Student> list = new ArrayList<>();
        connection = DBUtil.getConnection();

        //查询(页数，行数)
        String sql = "select * from student limit " + page + "," +rows;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer age = resultSet.getInt(3);
                student = new Student(id,name,age);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet, preparedStatement,connection);
        }
        return list;
    }

    //删除
    public static void deleteById(Integer id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from student where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(preparedStatement, connection);
        }
    }

//    //根据id查询
//    public static Student findById(Integer id){
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        Student student = null;
//        try {
//            connection = DBUtil.getConnection();
//            String sql = "select * from student where id = ?";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1,id);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Integer id2 = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                Integer age = resultSet.getInt(3);
//                student = new Student(id2,name,age);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DBUtil.close(resultSet, preparedStatement, connection);
//        }
//        return student;
//    }
    //修改
    public static void update(Integer id, String name, Integer age){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Student> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "update student set name = ?,age = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            System.out.println("执行了修改操作");

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(preparedStatement, connection);
        }
    }
}
