package com.chens.stwo.pojo;

import java.util.Date;

public class GitUser {

    private String name;
    private int age;
    private char sex;

    public void setName(String name,int age,char sex){
        this.age = age;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }


    @Override
    public String toString() {
        return "["+"name:"+this.name+",age:"+this.age+",sex:"+this.sex+"]";
    }
}
