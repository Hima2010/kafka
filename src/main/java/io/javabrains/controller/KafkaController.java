package io.javabrains.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.service.KafkaConsumerService;
import io.javabrains.service.KafkaProducerService;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
	@Autowired
    private KafkaProducerService kafkaProducerService;
	@Autowired
	private KafkaConsumerService kafkaConsumerService;
	@Autowired
    private RestTemplate restTemplate;

    // Endpoint to send a message to a Kafka topic
//    @PostMapping("/send")
//    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
//        kafkaProducerService.sendMessage(topic, message);
//        return "Message sent to topic: " + topic;
//    }
    
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody MyRequestBody myRequestBody) {
        kafkaProducerService.sendJsonMsg(myRequestBody);
        return ResponseEntity.ok("json Message sent to topic: ");
    }
    
//    @GetMapping("/messages")
//    public List<String> getConsumedMessages() {
//        return kafkaConsumerService.getMessages();
//    }
//    
//    @PostMapping("/subscribeTopic")
//    public String topicSubscription(@RequestParam String topic) {
//    	KafkaMessageListenerContainer<String, String> container =  (KafkaMessageListenerContainer<String, String>) kafkaConsumerService.subscribeToTopic(topic);
//    	System.out.println("testing container output "+container);
//    	return "Subscribed to topic: " + topic;
//    }
    
    
//    @PostMapping("/external")
//    public ResponseEntity<String> callExternalApi(@RequestBody MyRequestBody requestBody) {
//        String apiUrl = "https://api.example.com/external-endpoint";
//
//        // Set the headers (if needed)
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        // Create an HTTP entity with the request body and headers
//        HttpEntity<MyRequestBody> requestEntity = new HttpEntity<>(requestBody, headers);
//
//        // Make an HTTP POST request
//        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestEntity, String.class);
//
//        // Return the response received from the external API
//        return response;
//    }
    
    
}
