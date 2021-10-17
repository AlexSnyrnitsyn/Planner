package com.example.planner.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompositeProducerImpl implements CompositeProducer {

    @Autowired
    @Qualifier("topicJmsTemplate")
    private JmsTemplate jmsTemplate;

    String topic = "BAR";

    public void sendMessage(String message){

        log.info("Sending message " + message + " to topic - " + topic);

        jmsTemplate.convertAndSend(topic, message);
    }
}
