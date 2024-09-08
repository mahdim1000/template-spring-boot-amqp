package org.radargps.springbootrabbitmq.tmp1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SenderQueue1 {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Queue queue1;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Queue 1.";
        this.rabbitTemplate.convertAndSend(queue1.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
