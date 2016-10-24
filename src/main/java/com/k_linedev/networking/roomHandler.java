package com.k_linedev.networking;

import com.k_linedev.POJO.Message;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


/**
 * Created by caden on 7/13/16.
 */
class roomHandler implements Runnable  {
    private BufferedReader in;
    private PrintWriter out;
    private Message lastMessage;
    private Messaging messaging = Messaging.getInstance();


    public roomHandler(Socket client) throws IOException {
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    @Override
    public void run() {
        while (true){

            ArrayList<Message> messages = messaging.sending();
         if (!(lastMessage.equals(messages.get(messages.size() -1)))){
             for (Message message : messages) {
                 boolean alreadysent = false;
                 if (alreadysent){
                     out.println(message);
                 }
                 if (lastMessage.equals(message)){
                     alreadysent = true;
                 }
             }
             lastMessage = messages.get((messages.size() -1 ));
         }
            try {
                messaging.addMessage(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }


        }
    }
}
