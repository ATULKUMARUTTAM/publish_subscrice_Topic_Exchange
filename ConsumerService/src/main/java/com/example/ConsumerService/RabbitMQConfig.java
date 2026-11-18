package com.example.ConsumerService;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    public static final String EXCHANGE_NAME = "my.exchange";

    public static final String BILLING_QUEUE="billing.queue";

    public static final String NOTIFICATION_QUEUE = "notification.queue";

 //   @Bean
//    public TopicExchange topicExchange()
//    {
//        return new TopicExchange(EXCHANGE_NAME,true,false);
//    }
    @Bean
    public FanoutExchange fanoutExchange()
    {
        return new FanoutExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue billingQueue()
    {
        return new Queue(BILLING_QUEUE,true);
    }

    @Bean
    public Queue notificationQueue()
    {
        return new Queue(NOTIFICATION_QUEUE,true);
    }

    @Bean
    public Binding billingBinding()
    {
        return BindingBuilder.bind(billingQueue())
                .to(fanoutExchange());

    }

    @Bean
    public Binding notificationBinding()
    {
        return BindingBuilder.bind(notificationQueue())
                .to(fanoutExchange());
    }


}
