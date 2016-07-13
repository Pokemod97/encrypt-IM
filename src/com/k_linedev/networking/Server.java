package com.k_linedev.networking;

import java.net.*;
import java.util.*;
import java.io.*;


/**
 * Created by caden on 7/12/16.
 */
public class abstract Server {
    private int port;
    private ServerSocket ss;
    public Server(){
        port = 1234;
    }
    public Server(int port){
        port = 1234;
        new ServerSocket(port);
        }
    public abstract listen(){

        }
}
