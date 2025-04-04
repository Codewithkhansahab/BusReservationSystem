package com.reservation.Model;

public class User {
    private int id;
    private String userName;
    private int password;
    private boolean isAdmin;

    public User(int id,String userName,int password,boolean isAdmin){
        this.id=id;
        this.userName=userName;
        this.password=password;
        this.isAdmin=isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
