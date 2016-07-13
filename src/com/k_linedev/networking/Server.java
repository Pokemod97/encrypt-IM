package com.k_linedev.networking;

/**
 * Created by caden on 7/12/16.
 */
public class abstract Server {
    private int port;
    public Server(){
        port = 1234;
    }
    public Server(int port){
        port = 1234;
        }
    public abstract listen(){

        }
}
