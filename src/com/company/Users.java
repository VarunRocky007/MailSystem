package com.company;

import java.util.ArrayList;

public class Users extends Email{
    static int id=1;
    int userId;
    String email;
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
//    public void storeSent(Users toUser,String subject,String content){
//        Mail newMail = new Mail();
//        newMail.setToMail(toUser.email);
//        newMail.setFromMail(this.email);
//        newMail.setSubject(subject);
//        newMail.setContent(content);
//        this.sentMail.add(newMail);
//    }
//    public void sendMail(Users toUser,String subject,String content){
//        this.storeSent(toUser,subject,content);
//        toUser.storeInbox(this,subject,content);
//        print("Inbox:");
//        this.showInbox();
//    }
//    public void storeInbox(Users fromUser,String subject,String content){
//        Mail newMail = new Mail();
//        newMail.setFromMail(fromUser.email);
//        newMail.setToMail(this.email);
//        newMail.setSubject(subject);
//        newMail.setContent(content);
//        this.inboxMail.add(newMail);
//        System.out.println("Mail sent successfully");
//    }
//    private static void print(String text){
//        System.out.println(text);
//    }
//    public void showInbox(){
//        System.out.println("Id\t\tFrom\t\tTo\t\tSubject\t\tContent");
//        for(Mail mail:this.inboxMail){
//           print(mail.getMailId()+"\t\t"+mail.getFromMail()+"\t"+mail.getToMail()+"\t"+mail.getSubject()+"\t"+
//                   mail.getContent());
//        }
//    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
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

    @Override
    ArrayList<Mail> returnInbox() {
        return this.inboxMail;
    }
    ArrayList<Mail> returnSent(){
        return this.sentMail;
    }
}
