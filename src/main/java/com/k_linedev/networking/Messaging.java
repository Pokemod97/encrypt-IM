package com.k_linedev.networking;

import com.k_linedev.POJO.Message;

import java.util.ArrayList;

import static com.k_linedev.latin.decryption.*;
import static com.k_linedev.latin.encryption.*;


/**
 * Created by caden on 7/13/16.
 */
public class Messaging {


    private final ArrayList<Message> in = new ArrayList<Message>();
    private final ArrayList<Message> out = new ArrayList<Message>();

    static private final Messaging messaging = new Messaging();
    private Message message = new Message();

    private Messaging(){
    }
    public synchronized  ArrayList<Message> getMessages(){
        return in;
    }
    public synchronized  void addMessage(Message message){
        this.message.setSender(decrypt(this.message.getSender()));
        this.message.setContent(decrypt(this.message.getContent()));
        in.add(this.message);
    }
    public synchronized  void send(Message message){
        this.message.setContent(encrypt(this.message.getContent()));
        this.message.setSender(encrypt(this.message.getSender()));
        out.add(this.message);

    }
    public synchronized  ArrayList<Message> sending(){
        return out;
    }
    public static synchronized Messaging getInstance(){
        return  messaging;
    }
}
