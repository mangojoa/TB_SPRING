package com.example.tb_spring;

import com.example.tb_spring.user.dao.UserDao;
import com.example.tb_spring.user.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class TbSpringApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao dao = new UserDao();

        User user = new User();
        user.setId("mangojoa05");
        user.setName("Namae");
        user.setPassword("nandesuka");

        dao.add(user);

        System.out.println(user.getId() + " Enroll Success");

//        SpringApplication.run(TbSpringApplication.class, args);
    }

}
