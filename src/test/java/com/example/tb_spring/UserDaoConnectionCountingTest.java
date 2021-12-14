package com.example.tb_spring;

import com.example.tb_spring.user.dao.CountingConnectionMaker;
import com.example.tb_spring.user.dao.CountingDaoFactory;
import com.example.tb_spring.user.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoConnectionCountingTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 자바 설정 코드를 사용하기 위한 AnnotationConfigApplicationContext!
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CountingDaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        /*
        DAO를 DL방식으로 가져와 어떤 작업이든 여러 번 실행시킨다.
        설정정보에 지정된 이름과 타입만 알면 특정 빈을 가져올 수 있으니 CountingConnectionMaker 오브젝트를 가져오는 건 간단하다.
        */
        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection Counter : " + ccm.getCounter());
    }
}
