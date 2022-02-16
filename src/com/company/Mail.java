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
