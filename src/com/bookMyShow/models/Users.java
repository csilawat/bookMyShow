package com.bookMyShow.models;

public class Users {

    String name;
    String email;
    long phoneNo;
    int age;

    public Users() {
    }

    public Users(String name, String email, long phoneNo, int age) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Users setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Users setEmail(String email) {
        this.email = email;
        return this;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public Users setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Users setAge(int age) {
        this.age = age;
        return this;
    }
}
