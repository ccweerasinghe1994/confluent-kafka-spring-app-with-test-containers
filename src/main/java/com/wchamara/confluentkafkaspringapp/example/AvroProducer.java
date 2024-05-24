package com.wchamara.confluentkafkaspringapp.example;

import com.wchamara.confluentkafkaspringapp.dto.PoemValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AvroProducer {

    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, PoemValue> kafkaTemplate;

    public AvroProducer(KafkaTemplate<String, PoemValue> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String key, PoemValue value) {
        CompletableFuture<SendResult<String, PoemValue>> send = kafkaTemplate.send(topicName, key, value);

        send.whenComplete((result, exception) -> {
            if (exception == null) {
                System.out.println("Sent message=[" + value + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + value + "] due to : " + exception.getMessage());
            }
        });
    }


}
