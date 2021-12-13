package com.example.tb_spring.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

    /*
    인터페이스로 추상화해놓은 최소한의 통로를 통해 접근하는 쪽에서는 오브젝트를 만들때 사용할 클래스가 무엇인지 몰라도 된다.
    단지 인터페이스를 통해 원하는 기능을 사용하기만 하면 된다.

    이후 인터페이스가 어떤 일을 하겠다는 기능만 정의해놓은 상태이다. 어떻게 무엇을 하겠다는 구현 방법은 나타나 있지 않다.
    이는 인터페이스를 구현한 클래스들이 알아서 결정할 일이다.
    */
    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
