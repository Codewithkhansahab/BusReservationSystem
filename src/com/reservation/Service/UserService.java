package com.reservation.Service;

import com.reservation.DAO.UserDAO;

import java.sql.SQLException;

public class UserService {
    UserDAO userDAO;
    public UserService(){
        userDAO = new UserDAO();
    }
    public boolean loginUser(String userName,String passWord) throws SQLException {
        if(userName.isEmpty()||passWord.isEmpty()){
            System.out.println("User name or password can not be empty ");
            return false;
        }
        return userDAO.validateUser(userName,passWord);
    }
    public boolean registerUser(String userName, String passWord) throws SQLException {
        if (userName.length()<4){
            System.out.println("UserName should be atleast 4 character ");
            if (passWord.length()<6){
                System.out.println("password should be atleast 6 character ");
            }
            return false;
        }
        return userDAO.registerUser(userName,passWord);

    }
}
