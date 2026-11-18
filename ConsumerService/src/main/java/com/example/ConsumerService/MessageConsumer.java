package com.example.ConsumerService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer
{
    @RabbitListener(queues = RabbitMQConfig.BILLING_QUEUE)
    public void receiveBillingMessage(String message)
    {
        System.out.println("Billing Service received the message: "+message);
    }


    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void receiveNotificationMessage(String message)
    {
        System.out.println("Notification Service received the message: "+message);
    }



}
