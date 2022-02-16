package com.company;

public class Mail {
    static int id=1;
    int mailId;
    String fromMail;
    String toMail;
    String subject;
    String content;

    public int getMailId() {
        return mailId;
    }

    public Mail(){
        this.mailId=id;
        id+=1;
    }
    public void sendMail(Users fromUser,Email toEmail,String subject,String content){
        this.setFromMail(fromUser.getEmail());
        this.setToMail(toEmail.getEmail());
        this.setSubject(subject);
        this.setContent(content);
        fromUser.returnSent().add(this);
        toEmail.returnInbox().add(this);
        System.out.println("Email sent");
    }
    public void showInbox(Email email){
        System.out.println("Id\t\tFrom\t\tTo\t\tSubject\t\tContent");
        for(Mail mail:email.returnInbox()){
            System.out.println(mail.getMailId()+"\t\t"+mail.getFromMail()+"\t"+mail.getToMail()+"\t"+mail.getSubject()+"\t"+
                    mail.getContent());
        }
    }
    public void showSent(Users user){
        System.out.println("Id\t\tFrom\t\tTo\t\tSubject\t\tContent");
        for(Mail mail:user.returnSent()){
            System.out.println(mail.getMailId()+"\t\t"+mail.getFromMail()+"\t"+mail.getToMail()+"\t"+mail.getSubject()+"\t"+
                    mail.getContent());
        }
    }


    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
