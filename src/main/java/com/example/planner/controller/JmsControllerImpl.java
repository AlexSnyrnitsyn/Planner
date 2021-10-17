package com.example.planner.controller;

import com.example.planner.jms.CompositeProducer;
import com.example.planner.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JmsControllerImpl implements JmsController {

    private final CompositeProducer jmsProducer;

    @PostMapping("/topic")
    public void topic(@RequestBody User user) {
        jmsProducer.sendMessage(user.toString());
    }
}
