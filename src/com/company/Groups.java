package com.company;

import java.util.ArrayList;

public class Groups {
    static int id = 1;
    int groupId;
    String groupEmail;
    String groupName;
    String groupPassword;
    String groupDescription;
    ArrayList<Mail> inboxMail;
    ArrayList<Users> users;
    public Groups(){
        this.groupId = id;
        id+=1;
        this.inboxMail = new ArrayList<Mail>();
        this.users = new ArrayList<Users>();
    }

    public ArrayList<Users> getUsers() {
        return users;
    }
    public void storeInbox(Users fromUser,String subject,String content){
        Mail newMail = new Mail();
        newMail.setFromMail(fromUser.userEmail);
        newMail.setToMail(this.groupEmail);
        newMail.setSubject(subject);
        newMail.setContent(content);
        this.inboxMail.add(newMail);
        System.out.println("Mail sent successfully");
    }
    public void showInbox(){
        System.out.println("Id\t\tFrom\t\tTo\t\tSubject\t\tContent");
        for(Mail mail:this.inboxMail){
            System.out.println(mail.getMailId()+"\t\t"+mail.getFromMail()+"\t"+mail.getToMail()+"\t"+mail.getSubject()+"\t"+
                    mail.getContent());
        }
    }

    boolean isUserPresent(Users user){
        for(Users users: this.users){
            if(users.getUserEmail().equals(user.getUserEmail())){
                return true;
            }
        }
        return false;
    }
    public void addUser(Users user){
        if(!(isUserPresent(user))){
            this.users.add(user);
            System.out.println("User added Successfully");
        }
        else {
            System.out.println("User is already present");
        }
    }
    public String getGroupEmail() {
        return groupEmail;
    }

    public void setGroupEmail(String groupEmail) {
        this.groupEmail = groupEmail;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupPassword() {
        return groupPassword;
    }

    public void setGroupPassword(String groupPassword) {
        this.groupPassword = groupPassword;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }
}
