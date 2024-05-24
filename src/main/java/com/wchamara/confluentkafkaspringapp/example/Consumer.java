//package com.wchamara.confluentkafkaspringapp.example;
//
//import com.wchamara.confluentkafkaspringapp.dto.PoemValue;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Consumer {
//    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
//
//    @KafkaListener(topics = "${topic.name}", groupId = "springboot-group-1")
//    public void listen(ConsumerRecord<String,PoemValue> record) {
//        PoemValue value = record.value();
//        String key = record.key();
//        String topic = record.topic();
//
//        logger.info("Received message: {} from topic: {} with key: {}", value, topic, key);
//    }
//}
