package com.lhm.servlet.repository;

import com.lhm.servlet.Util.DBUtil;
import com.lhm.servlet.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC
 */
public class UserRepositroy {
    public static boolean checklogin(String username, String password){
        boolean flag = false;
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        User user = null;

        //查询
        String sql = "select * from user where username = '" + username +"'and password ='" +password +"'";
//        String sql = "select * from user where username = ? and password = ?";
        connection = DBUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("账号密码正确");
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet, statement ,connection);
        }
        return  flag;
    }

}
