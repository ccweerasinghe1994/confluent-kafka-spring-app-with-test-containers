package com.wchamara.confluentkafkaspringapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
public abstract class AbstractIntegrationTestContainer {
    private static final Logger log = LoggerFactory.getLogger(AbstractIntegrationTestContainer.class);

    private static final DockerImageName KAFKA_IMAGE = DockerImageName.parse("confluentinc/cp-kafka:7.6.1");
    private static final DockerImageName SCHEMA_REGISTRY_IMAGE = DockerImageName.parse("confluentinc/cp-schema-registry:7.6.1");


    private static final KafkaContainer kafkaContainer = new KafkaContainer(KAFKA_IMAGE)
            .withAccessToHost(true)
            .withEnv("CLUSTER_ID", "MkU3OEVBNTcwNTJENDM2Qk")
            .withEnv("KAFKA_LOG_DIRS", "/tmp/kraft-combined-logs")
            .withEnv("KAFKA_CONTROLLER_LISTENER_NAMES", "CONTROLLER")
            .withEnv("KAFKA_CONTROLLER_LISTENER_NAMES", "CONTROLLER")
            .withEnv("KAFKA_LISTENERS", "PLAINTEXT://broker:29092,CONTROLLER://broker:29093,PLAINTEXT_HOST://0.0.0.0:9093")
            .withEnv("KAFKA_CONTROLLER_QUORUM_VOTERS", "1@broker:29093")
            .withEnv("KAFKA_PROCESS_ROLES", "broker,controller")
            .withEnv("KAFKA_JMX_HOSTNAME", "localhost")
            .withEnv("KAFKA_JMX_PORT", "9101")
            .withEnv("KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR", "1")
            .withEnv("KAFKA_TRANSACTION_STATE_LOG_MIN_ISR", "1")
            .withEnv("KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS", "0")
            .withEnv("KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR", "1")
            .withEnv("KAFKA_ADVERTISED_LISTENERS", "PLAINTEXT://broker:29092,PLAINTEXT_HOST://localhost:9093")
            .withEnv("KAFKA_LISTENER_SECURITY_PROTOCOL_MAP", "CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT")
            .withEnv("KAFKA_NODE_ID", "1")
            .withEnv("KAFKA_INTER_BROKER_LISTENER_NAME", "PLAINTEXT");

    private static final GenericContainer<?> schemaRegistryContainer = new GenericContainer<>(SCHEMA_REGISTRY_IMAGE)
            .withExposedPorts(8081)
            .dependsOn(kafkaContainer)
            .withEnv("SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS", "PLAINTEXT://localhost:59254")
            .withAccessToHost(true)
            .withEnv("SCHEMA_REGISTRY_HOST_NAME", "schema-registry")
            .withEnv("SCHEMA_REGISTRY_LISTENERS", "http://0.0.0.0:8081");


//    @DynamicPropertySource
//    static void kafkaProperties(DynamicPropertyRegistry registry) {
//
//        log.info("Kafka bootstrap servers: {}", KAFKA_CONTAINER.getBootstrapServers());
//        log.info("Schema Registry URL: {}", "http://" + SCHEMA_REGISTRY.getHost() + ":" + SCHEMA_REGISTRY.getFirstMappedPort());
//        registry.add("spring.kafka.bootstrap-servers", KAFKA_CONTAINER::getBootstrapServers);
//        registry.add("spring.kafka.properties.schema.registry.url", () ->
//                "http://" + SCHEMA_REGISTRY.getHost() + ":" + SCHEMA_REGISTRY.getFirstMappedPort());
//    }


    @DynamicPropertySource
    static void kafkaProperties(DynamicPropertyRegistry registry) {
        kafkaContainer.start();
        registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
        registry.add("spring.kafka.properties.schema.registry.url", () ->
                "http://" + schemaRegistryContainer.getHost() + ":" + schemaRegistryContainer.getFirstMappedPort());
    }


}
