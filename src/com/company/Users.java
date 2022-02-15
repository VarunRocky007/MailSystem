package com.company;

import java.util.ArrayList;

public class Users {
    static int id=1;
    int userId;
    String userEmail;
    String userName;
    String userPassword;
    ArrayList<Mail> inboxMail;
    ArrayList<Mail> sentMail;
    public Users(){
        this.userId = id;
        id+=1;
        this.inboxMail = new ArrayList<Mail>();
        this.sentMail = new ArrayList<Mail>();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
