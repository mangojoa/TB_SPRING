package com.example.tb_spring.user.domain;

// 기본 생성자를 생성하는 클래스
public class User {
    String id;
    String name;
    String password;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
