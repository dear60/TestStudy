package com.mingful.www.testshiro.dao;

import com.mingful.www.testshiro.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;


@Repository
public class UserDao {
    public User findByUsername(String username) {
        User user = new User();
        String sql = "select id,username,salt,password from user_t where username = ? limit 1";
        System.out.println(sql);
        Connection connection = getConn();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setSalt(rs.getString(3));
                user.setPassword(rs.getString(4));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int saveUser(User user) {
        String sql = "insert user_t(username,salt,password) values (?,?,?)";
        Connection connection = getConn();
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getSalt());
            ps.setString(3, user.getPassword());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/enceladus";
        String username = "root";
        String password = "rootfmf";
        Connection conn = null;
        try {
            //classLoader,加载对应驱动
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
