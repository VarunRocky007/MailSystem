package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class MailSystem {
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
        ArrayList<Users> usersList = new ArrayList<Users>();
        ArrayList<Groups> groupsList = new ArrayList<Groups>();
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        while(cont){
            System.out.println("Enter the choice:\n1.AddUser\n2.AddGroup\n3.AddUserToGroup\n4.SendMail\n5.Inbox\n" +
                    "6.SentMail\n7.DeleteMail\n8.DeleteSentMail\n9.Exit\n");
            int choice = scan.nextInt();
            boolean canInsert;
            switch(choice){
                case 1:
                    canInsert = true;
                    System.out.println("Enter new user email: ");
                    String userEmail = scan.next();
                    for(Users user : usersList){
                        if(user.getUserEmail().equals(userEmail)){
                            System.out.println("User already exists");
                            canInsert = false;
                        }
                    }
                    for(Groups group : groupsList){
                        if(group.getGroupEmail().equals(userEmail)){
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
                            newUser.setUserEmail(userEmail);
                            newUser.setUserPassword(userPass);
                            usersList.add(newUser);
                        }
                        else{
                            System.out.println("Check your Password, Try again...");
                        }
                    }
                    break;
                case 2:
                    canInsert = true;
                    System.out.println("Enter the email for group");
                    String groupEmail = scan.next();
                    for(Users users : usersList){
                        if(users.getUserEmail().equals(groupEmail)){
                            System.out.println("User already exists with this mail.");
                            canInsert = false;
                        }
                    }
                    for(Groups group : groupsList){
                        if(group.getGroupEmail().equals(groupEmail)){
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
                            newGroup.setGroupEmail(groupEmail);
                            newGroup.setGroupPassword(groupPass);
                            newGroup.setGroupDescription(groupDesc);
                            groupsList.add(newGroup);
                        }
                        else {
                            System.out.println("Check the password, try again...");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the group mail");
                    String groupMail = scan.next();
                    Groups currentGroup = null;
                    for(Groups group: groupsList){
                        if(group.getGroupEmail().equals(groupMail)){
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
                                System.out.println(user.getUserName()+" : "+user.getUserEmail());
                            }
                            System.out.println("Users Present in Group: "+currentGroup.getGroupName());
                            for(Users user:currentGroup.getUsers()){
                                System.out.println(user.getUserName()+" : "+user.getUserEmail());
                            }
                            System.out.println("Enter the user mail to add to this group");
                            String userMail = scan.next();
                            Users user = null;
                            for (Users users:usersList){
                                if(users.getUserEmail().equals(userMail)){
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
                    break;
                case 4:
                    break;
                case 5:
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
