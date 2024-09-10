package org.radargps;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Queue warnQueue() {
        return new Queue("warning");
    }

    @Bean
    public Queue errorQueue() {
        return new Queue("error");
    }

    @Bean
    public Queue infoQueue() {
        return new Queue("info");
    }

    @Bean
    public Queue debugQueue() {
        return new Queue("debug");
    }

    @Bean
    public Binding warnBinding(DirectExchange directExchange, Queue warnQueue) {
        return BindingBuilder.bind(warnQueue)
                .to(directExchange)
                .with("warning.routing.key");
    }

    @Bean
    public Binding errorBinding(DirectExchange directExchange, Queue errorQueue) {
        return BindingBuilder.bind(errorQueue)
                .to(directExchange)
                .with("error.routing.key");
    }

    @Bean
    public Binding infoBinding(DirectExchange directExchange, Queue infoQueue) {
        return BindingBuilder.bind(infoQueue)
                .to(directExchange)
                .with("info.routing.key");
    }

    @Bean
    public Binding debugBinding(DirectExchange directExchange, Queue debugQueue) {
        return BindingBuilder.bind(debugQueue)
                .to(directExchange)
                .with("debug.routing.key");
    }
}
