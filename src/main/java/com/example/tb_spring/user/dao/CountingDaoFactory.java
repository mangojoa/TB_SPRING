package com.example.tb_spring.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {

    // [21.12.14] 수정자 메소드를 이용한 DI 방식을 이용
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }

    /* [21.12.14] 생성자를 이용한 DI 방식을 이용
    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }
    */

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new MConnectionMaker();
    }

    /* [21.12.14]
    realConnectionMaker에 DB 커넥터를 받아서 리턴 값을 통해 새로운 생성자를 만들고
    connectionMaker에 해당 (realConnectionMaker)인자를 리턴 값에 넘겨 받아
    새로운 생성자(CountingConnectionMaker)를 생성한다.
    마지막으로 이를 new UserDao의 인자값에 사용하여 최종적인 생성자를 생성한다.

    이렇게 여러번 나누는 이유는 관리를 편하게 하기위한 스프링의 철학(?)이 들어가 있는 구조 같다.
    이와 더불어 재사용성을 위한 부분이기도 한것 같다.
    */
}
