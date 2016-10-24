package com.k_linedev;

import com.k_linedev.POJO.Message;
import org.junit.Test;
import com.k_linedev.networking.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by caden on 9/13/16.
 */
public class network {
    @Test
    public void Message(){
        String messageContent = "message";
        Message message = new Message(messageContent);
        assertEquals(messageContent, message.getContent());
    }
    @Test
    public void client(){
        Chat chat = new Chat("localhost");


    }

}
