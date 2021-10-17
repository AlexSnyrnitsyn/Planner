package com.example.planner.jms;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

    @Slf4j
    @Component
    public class CompositeListenerImpl implements CompositeListener {

        String topic = "BAR";

        @JmsListener(destination = "BAR", containerFactory = "topicListenerFactory")
        public void receiveMessageFromForwardTopic(Message jsonMessage) throws JMSException {

            TextMessage textMessage = (TextMessage) jsonMessage;
            String messageData = textMessage.getText();
            log.info("Received message: " + messageData + " from topic - " + topic);
        }
    }

