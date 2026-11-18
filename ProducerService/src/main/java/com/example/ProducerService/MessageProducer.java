package com.example.ProducerService;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer
{
    private final RabbitTemplate rabbitTemplate;
    public void sendMessage(String message)
    {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "order.created", message);

        System.out.println("Message sent!!!");
    }
}
