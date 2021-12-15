package com.example.tb_spring.user.dao;

import javax.sql.CommonDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Wrapper;

public interface DataSource extends CommonDataSource, Wrapper {
    Connection getConnection() throws SQLException;

    /* [21.12.15]
    DAO에서는 DataSource의 getConnection()메소드를 이용해 DB커넥션을 가져오게 하면 된다.
    (사실 getConnection() = makeConnection() 은 같은 역할을 하고 있다고 보면 된다.)

    DataSource의 getConnection()은 SQLException만 던지기 때문에 makeConnection() 메소드에 throws에 선언했던
    ClassNotFoundException은 제거해도 된다.
    */
}
