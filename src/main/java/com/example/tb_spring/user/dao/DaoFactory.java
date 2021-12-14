package com.example.tb_spring.user.dao;

/* [21.12.14]
객체의 생성 방법을 결정하고 그렇게 만들어진 오브젝트를 돌려주는 것이아.
이는 오브젝트를 생성하는 쪽과 생성된 오브젝츠를 사용하는 쪽의 역할과 책임을 깔끔하게 분리하려는 목적으로 사용
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* [21.12.14]
DaoFactory를 스프링의 빈 팩토리가 사용할 수 있는 본격적인 설정정보 만들기
@Configuration => 스프링이 빈 팩토리를 위한 오브젝트 설정을 담당하는 클래스라고 인식할 수 있도록 하는 어노테이션
@Bean => 오브젝트를 만들어주는 어노테이션
*/

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new MConnectionMaker();
    }

    /* [21.12.14] 생성자 DI를 사용하는 팩토리 메소드
    @Bean
    드ublic UserDao userDao() {
        // 팩토리의 메소드는 userdao 타입의 오브젝트를 어떻게 만들고 어떻게 준비시킬지를 결정한다.
        return new UserDao(connectionMaker());
        // ConnectionMaker connectionmaker 를 분리하여 UserDao userDao()를 간결하게 작성
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new MConnectionMaker();
    }
    */
}
