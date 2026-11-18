package com.example.ProducerService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageProducer messageProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message)
    {
        messageProducer.sendMessage(message);
        return "Message Published successfully!!!";
    }
}
