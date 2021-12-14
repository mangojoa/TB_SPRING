package com.example.tb_spring;

import com.example.tb_spring.user.dao.ConnectionMaker;
import com.example.tb_spring.user.dao.DaoFactory;
import com.example.tb_spring.user.dao.MConnectionMaker;
import com.example.tb_spring.user.dao.UserDao;
import com.example.tb_spring.user.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConnectionMaker connectionMaker = new MConnectionMaker();

        /* [21.12.14]
         이 부분은 DaoFactory를 만들면서 분리된 코드이다.
         이제는 DaoFactory를 통해 UserDao 오브젝트를 받아다가 자신의 관심사인 테스트를 위해 활용하기만 하면 그만
         UserDao dao = new UserDao(connectionMaker);
        */

        /* [21.12.14]
        UserDao dao = new DaoFactory().userDao();
        AnnotationConfigApplicationContext를 사용하게 되면서 이제는 사용하지 않는다.

        DaoFactory처럼 @Configuration이 붙은 자바 코드를 설정 정보로 사용하려면
        AnnotationConfigApplicationContext를 이용하면 된다.
        어플리케이션 컨텍스트를 만들 때 생성자 파라미터로 DaoFactory 클래스를 넣어준다.
        */

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        /*
        AnnotationConfigApplicationContext를 통해 실행하면 이전 실행과는 다르게 콘솔창에서
        DaoFactory를 통한 오브잭트 생성 로그를 확인할 수 있게 된다.
        */

        User user = new User();
        user.setId("E");
        user.setName("Name");
        user.setPassword("Password");

        dao.add(user);

        System.out.println(user.getId() + " Enroll Success");

//        SpringApplication.run(TbSpringApplication.class, args);
    }
}
