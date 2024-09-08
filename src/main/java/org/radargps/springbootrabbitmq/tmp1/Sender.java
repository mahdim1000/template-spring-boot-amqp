package org.radargps.springbootrabbitmq.tmp1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Queue helloQueue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!";
        this.rabbitTemplate.convertAndSend(helloQueue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
