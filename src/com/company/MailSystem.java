package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class MailSystem {
    static ArrayList<Users> usersList = new ArrayList<Users>();
    static ArrayList<Groups> groupsList = new ArrayList<Groups>();
    static void addUser(){
        Scanner scan = new Scanner(System.in);
        boolean canInsert = true;
        System.out.println("Enter new user email: ");
        String userEmail = scan.next();
        for(Users user : usersList){
            if(user.getEmail().equals(userEmail)){
                System.out.println("User already exists");
                canInsert = false;
            }
        }
        for(Groups group : groupsList){
            if(group.getEmail().equals(userEmail)){
                System.out.println("Group exists with this email");
                canInsert = false;
            }
        }
        if(canInsert){
            System.out.println("Enter the user name:");
            String userName = scan.next();
            System.out.println("Enter the new password");
            String tempPass = scan.next();
            System.out.println("Re enter the new password");
            String userPass = scan.next();
            if(tempPass.equals(userPass)){
                Users newUser = new Users();
                newUser.setUserName(userName);
                newUser.setEmail(userEmail);
                newUser.setUserPassword(userPass);
                usersList.add(newUser);
                System.out.println("User added successfully..");
            }
            else{
                System.out.println("Check your Password, Try again...");
            }
        }

        }
    static void addGroup(){
        Scanner scan = new Scanner(System.in);
        boolean canInsert = true;
        System.out.println("Enter the email for group");
        String groupEmail = scan.next();
        for(Users users : usersList){
            if(users.getEmail().equals(groupEmail)){
                System.out.println("User already exists with this mail.");
                canInsert = false;
            }
        }
        for(Groups group : groupsList){
            if(group.getEmail().equals(groupEmail)){
                System.out.println("Group exists with this email");
                canInsert = false;
            }
        }
        if(canInsert){
            System.out.println("Enter the Group Name:");
            String groupName = scan.next();
            System.out.println("Enter the group password:");
            String tempPass = scan.next();
            System.out.println("Re enter the group password");
            String groupPass = scan.next();
            if(tempPass.equals(groupPass)){
                Groups newGroup = new Groups();
                System.out.println("Enter the group description:");
                String groupDesc = scan.next();
                newGroup.setGroupName(groupName);
                newGroup.setEmail(groupEmail);
                newGroup.setGroupPassword(groupPass);
                newGroup.setGroupDescription(groupDesc);
                groupsList.add(newGroup);
                System.out.println("Group added successfully");
            }
            else {
                System.out.println("Check the password, try again...");
            }
        }
    }
    static void addUserToGroup(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the group mail");
        String groupMail = scan.next();
        Groups currentGroup = null;
        for(Groups group: groupsList){
            if(group.getEmail().equals(groupMail)){
                currentGroup = group;
            }
        }
        if(currentGroup == null){
            System.out.println("Group doesn't exist");
        }
        else{
            System.out.println("Enter the group password:");
            String password = scan.next();
            if(currentGroup.getGroupPassword().equals(password)){
                System.out.println("Users Present");
                for(Users user:usersList){
                    System.out.println(user.getUserName()+" : "+user.getEmail());
                }
                System.out.println("Users Present in Group: "+currentGroup.getGroupName());
                for(Users user:currentGroup.getUsers()){
                    System.out.println(user.getUserName()+" : "+user.getEmail());
                }
                System.out.println("Enter the user mail to add to this group");
                String userMail = scan.next();
                Users user = null;
                for (Users users:usersList){
                    if(users.getEmail().equals(userMail)){
                        user=users;
                    }
                }
                if(user==null){
                    System.out.println("User doesn't exist");
                }
                else {
                    currentGroup.addUser(user);
                }
            }
            else {
                System.out.println("Password is wrong, Try again...");
            }
        }
    }
    public static void print(String text){
        System.out.println(text);
    }
    public static void sendMail(){
        Scanner scan = new Scanner(System.in);
        print("Enter the user mail:");
        String userMail = scan.next();
        Users user = null;
        for(Users users:usersList){
            if(users.getEmail().equals(userMail)){
                user=users;
            }
        }
        if(user==null){
            print("User not found");
        }
        else{
            print("Enter the password");
            String pass = scan.next();
            if(user.getUserPassword().equals(pass)){
                print("Emails present");
                for (Users users:usersList){
                    print(users.getEmail());
                }
                for (Groups groups:groupsList){
                    print(groups.email);
                }
                print("Enter the user email to send mail:");
                String toUserMail = scan.next();
                Email toEmail = null;
                for (Users users:usersList){
                    if(users.getEmail().equals(toUserMail)){
                        toEmail = users;
                    }
                }
                for (Groups groups:groupsList){
                    if(groups.getEmail().equals(toUserMail)){
                        toEmail = groups;
                    }
                }
                if(toEmail==null){
                    print("User not found try again...");
                }
                else{
                    print("Enter the subject");
                    String subject = scan.next();
                    print("Enter the content");
                    String content = scan.next();
                    Mail newMail = new Mail();
                    newMail.sendMail(user,toEmail,subject,content);
                }
            }
            else {
                print("Pass doesn't match");
            }
        }
    }
    public static void inbox(){
        print("Which inbox should be shown");
        print("Users present");
        for(Users users:usersList){
            print(users.getEmail());
        }
        print("Groups present");
        for(Groups groups:groupsList){
            print(groups.getEmail());
        }
        Email email = null;
        Mail mail = new Mail();
        Scanner scanner = new Scanner(System.in);
        String emailId = scanner.next();
        for (Users users:usersList){
            if(users.getEmail().equals(emailId)){
                email=users;
            }
        }
        for(Groups groups:groupsList){
            if(groups.getEmail().equals(emailId)){
                email=groups;
            }
        }
        if(email==null){
            print("Enter the valid email");
        }
        else {
            mail.showInbox(email);
        }
    }
    public static void main(String[] args) {
        /**1.User~
         * 2.Group~
         * 3.AddingUserToGroup~
         * 4.SendMail
         * 5.Inbox
         * 6.SentMail
         * 7.DeleteMail
         * 8.DeleteSentMail
         * 9.Exit
        **/
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        while(cont){
            System.out.println("Enter the choice:\n1.AddUser\n2.AddGroup\n3.AddUserToGroup\n4.SendMail\n5.Inbox\n" +
                    "6.SentMail\n7.DeleteMail\n8.DeleteSentMail\n9.Exit\n");
            int choice = scan.nextInt();
            boolean canInsert;
            switch(choice){
                case 1:
                    addUser();
                    break;
                case 2:
                    addGroup();
                    break;
                case 3:
                    addUserToGroup();
                    break;
                case 4:
                    sendMail();
                    break;
                case 5:
                    inbox();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    cont = false;
                    break;
                default:
                    System.out.println("Enter the valid option");
            }
        }
    }
}
