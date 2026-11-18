package com.example.ProducerService;


import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    public static final String EXCHANGE_NAME = "my.exchange";




    @Bean
    public TopicExchange topicExchange()
    {
        return new TopicExchange(EXCHANGE_NAME, true, false);
    }
}
