package com.k_linedev.POJO;

/**
 * Created by caden on 9/12/16.
 */
public class Message {

    private String sender;
    private String content;

    private boolean quit;
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean isQuit() {
        return quit;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message(){
    quit = false;
    }
    public Message(boolean quit){
        this.quit = quit;
    }
    public Message(String content){
       this.content = content;
    }
}
