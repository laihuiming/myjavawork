package com.lhm.servlet.repository;

import com.lhm.servlet.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterRepositrory {
    //注册
    public static void register(String username, String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into user (username,password) value (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(preparedStatement, connection);
        }
    }
}
