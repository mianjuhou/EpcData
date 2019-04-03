
package com.potevio.messagequeue.receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void receiveMessage(String message) {
        logger.info("Received 接收到的消息:" + message);
    }
}