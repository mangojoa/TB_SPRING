package com.example.tb_spring.user.dao;

import com.example.tb_spring.user.domain.User;

import java.sql.*;

public class UserDao {

    // interface를 통해 오브젝트에 접근하므로 구체적인 클래스 정보를 알 필요가 없다.
    private ConnectionMaker connectionMaker;

    public UserDao() {
        connectionMaker = new MConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        // 인터페이스에 정의된 메소드를 사용하므로 클래스가 바뀐다고 해도 메소드 이름이 변경될 걱정은 없어진다.

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

}
