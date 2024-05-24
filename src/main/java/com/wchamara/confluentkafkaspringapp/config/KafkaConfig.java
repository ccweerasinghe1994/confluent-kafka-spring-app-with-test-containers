package com.wchamara.confluentkafkaspringapp.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    private final Logger logger= LoggerFactory.getLogger(KafkaConfig.class);

    @Value("${topic.name}")
    private String topicName;

    @Bean
    public NewTopic createTopic(){
        logger.info("Creating topic 'poems'");
        return new NewTopic(topicName, 3, (short) 1);
    }
}
