package io.javabrains.service;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import io.javabrains.controller.MyRequestBody;

@Service
public class KafkaProducerService {
	
	//private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(KafkaProducerService.class);
	
	//@Autowired
    private KafkaTemplate<String, MyRequestBody> kafkaTemplate;
	
	@Autowired
    public KafkaProducerService(KafkaTemplate<String, MyRequestBody> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    public void sendMessage(String topic, String message) {
//        kafkaTemplate.send(topic, message);
//    }
    
    public void sendJsonMsg(MyRequestBody data) {
        //LOGGER.info(String.format("message sent -> %s ",data));
        
        Message<MyRequestBody> message = MessageBuilder
        		.withPayload(data)
        		.setHeader(KafkaHeaders.TOPIC, "test-topic")
        		.build();
       
        kafkaTemplate.send(message);
    }

	public String subsribeTopic(MyRequestBody requestBody) {
		
		return null;
		// TODO Auto-generated method stub	
	}
}
