package com.k_linedev.networking;

import com.k_linedev.POJO.Message;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by caden on 7/13/16.
 */
public class onebyoneServer extends Server {
    private String password;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private ArrayList<Message> Messages;
    private Message lastMessage;
    private Messaging messaging = Messaging.getInstance();
    private Socket s;

    public onebyoneServer(int port){
        super(port);
        try {
            s = ss.accept();
            out = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
   public void listen(){
            new Thread(() -> {

                while (true) {
                    Messages = messaging.sending();
                    if (!(lastMessage == Messages.get(Messages.size() - 1))) {
                        boolean alreadysent = false;
                        for (Message messages : Messages) {
                            if (alreadysent) {
                                try {
                                    out.writeObject(messages);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (lastMessage.equals(messages)) {
                                alreadysent = true;
                            }
                        }
                        lastMessage = Messages.get((Messages.size() - 1));
                        if(lastMessage.isQuit()){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    try {

                       messaging.addMessage((Message) in.readObject());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

}


}
