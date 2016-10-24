package com.k_linedev.networking;

import java.net.*;
import java.io.*;

/*
  Created by caden on 7/12/16.
 */
abstract class Server {
    private int port;
    ServerSocket ss;

    public Server(){
        port = 1234;
    }
    public Server(int port){
        this.port = port;
        try {


            ss = new ServerSocket(port);
        } catch (IOException e){
            System.out.print(e.toString());
        }
        }
    public abstract void listen();


}
