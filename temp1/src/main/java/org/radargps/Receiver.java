package org.radargps;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "warning")
    public void receiveWarning(String message) {
        System.out.println("Received Warning: " + message);
    }

    @RabbitListener(queues = "info")
    public void receiveInfo(String message) {
        System.out.println("Received Info: " + message);
    }

    @RabbitListener(queues = "error")
    public void receiveError(String message) {
        System.out.println("Received Error: " + message);
    }

    @RabbitListener(queues = "debug")
    public void receiveDebug(String message) {
        System.out.println("Received Debug: " + message);
    }
}
