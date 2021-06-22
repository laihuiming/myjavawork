package com.lhm.servlet.Util;

import java.sql.*;

public class DBUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/myjavawork?serverTimezone=PRC";
    private static String user = "root";
    private static String password = "123456";

    //加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //连接对象
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭流，释放资源
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement !=null){
                statement.close();
            }
            if (connection !=null){
                connection.close();
            }
        }catch(SQLException e){
                e.printStackTrace();
            }
        }

    public static void close(PreparedStatement preparedStatement,Connection connection){
        close(null,preparedStatement,connection);
    }
}
