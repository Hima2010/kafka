package io.javabrains.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.web.client.RestTemplate;

import io.javabrains.controller.MyRequestBody;

@Configuration
public class KafkaProducerConfig {

	@Bean
    public ProducerFactory<String, MyRequestBody> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        // Add producer properties
        config.put("bootstrap.servers", "localhost:9092");
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.springframework.kafka.support.serializer.JsonSerializer");
        
        return new DefaultKafkaProducerFactory<>(config);
    }

    // Define the KafkaTemplate bean
    @Bean
    public KafkaTemplate<String, MyRequestBody> kafkaTemplate() {
    	return new KafkaTemplate<>(producerFactory());
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
