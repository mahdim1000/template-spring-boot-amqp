package org.radargps;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    public void sendWarning(String message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "warning.routing.key", message);
    }

    public void sendInfo(String message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "info.routing.key", message);
    }

    public void sendError(String message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "error.routing.key", message);
    }
    public void sendDebug(String message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "debug.routing.key", message);
    }
}
