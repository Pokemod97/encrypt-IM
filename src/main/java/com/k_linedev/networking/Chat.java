package com.k_linedev.networking;

import com.k_linedev.POJO.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static com.k_linedev.latin.encryption.encrypt;

/**
 * Created by caden on 9/21/16.
 */
public class Chat implements Runnable {
    int port = 1234;
    String address;
    Socket socket;
    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;

    public Chat(int port, String address){
        this.port = port;
        this.address = address;
        try {
            socket = new Socket(address.toString(), port);

         outputStream = new ObjectOutputStream(socket.getOutputStream());
         inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Chat(String address ){
        this.address = address;

    }


    @Override
    public void run() {
        try {

            while (true){
                Message message = (Message) inputStream.readObject();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void send(Message message){
        try {
            message.setContent(encrypt(message.getContent()));
            message.setSender(encrypt(message.getSender()));
            outputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
