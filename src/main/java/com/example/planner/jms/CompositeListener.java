package com.example.planner.jms;

import org.apache.activemq.Message;

import javax.jms.JMSException;

public interface CompositeListener {

    void receiveMessageFromForwardTopic(Message jsonMessage) throws JMSException;

}
