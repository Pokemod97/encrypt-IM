package com.k_linedev.networking;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by caden on 7/13/16.
 */
public class roomServer extends Server {
    @Override
    public void listen() {
        while (true) {
            try {
                Socket s = ss.accept();
                new Thread(new roomHandler(s)).start();


            } catch (IOException e) {
                System.out.print(e.toString());
                break;
            }
        }
    }
}