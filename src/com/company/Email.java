package com.company;

import java.util.ArrayList;

abstract public class Email {
    public String email;
    void setEmail(String email){
            this.email=email;
    }
    String getEmail(){
        return this.email;
    }

    abstract ArrayList<Mail> returnInbox();
}
