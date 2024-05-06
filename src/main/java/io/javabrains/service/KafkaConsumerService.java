package io.javabrains.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Service;

import io.javabrains.controller.MyRequestBody;

@Service
public class KafkaConsumerService {
	
	@Autowired
    private ConsumerFactory<String, String> consumerFactory;
	
//	public MessageListenerContainer subscribeToTopic(String topic) {
//        ContainerProperties containerProperties = new ContainerProperties(topic);
//        containerProperties.setGroupId("dynamic-group");
//        
//        KafkaMessageListenerContainer<String, String> container =
//            new KafkaMessageListenerContainer<>(consumerFactory, containerProperties);
//        
//        MessageListener<String, String> messageListener = message -> {
//            System.out.println("Received message: " + message);
//            // Add your message processing logic here
//        };
//
//        // Set the message listener for the container
//        container.setupMessageListener(messageListener);
//        
//        container.start();
//        return container;
//    }

	private final List<String> messages = new ArrayList<>();
	@KafkaListener(topics = "test-topic", groupId = "my-group-id")
    public void consume(MyRequestBody myRequestBody) {
        System.out.println("Received message: " + myRequestBody.toString());
        // Store the received message in the list
		/*
		 * synchronized (messages) { messages.add(message); }
		 */
    }

    // Method to retrieve consumed messages
    public List<String> getMessages() {
        synchronized (messages) {
            return new ArrayList<>(messages);
        }
    }

    // Method to clear consumed messages
    public void clearMessages() {
        synchronized (messages) {
            messages.clear();
        }
    }
}
