package com.wchamara.confluentkafkaspringapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import java.io.File;

//@SpringBootTest
//@Testcontainers
public abstract class AbstractIntegrationTestContainerWithDockerComposeFile {
    private static final Logger log = LoggerFactory.getLogger(AbstractIntegrationTestContainerWithDockerComposeFile.class);

    private static final DockerImageName KAFKA_IMAGE = DockerImageName.parse("confluentinc/cp-kafka:7.6.1");
    private static final DockerImageName SCHEMA_REGISTRY_IMAGE = DockerImageName.parse("confluentinc/cp-schema-registry:7.6.1");

    private static final Network NETWORK = Network.newNetwork();


    //    @Container
//    private static final KafkaContainer KAFKA_CONTAINER =
//            new KafkaContainer(KAFKA_IMAGE)
//                    .withNetwork(NETWORK);
//    @Container
//    private static final GenericContainer<?> SCHEMA_REGISTRY =
//            new GenericContainer<>(SCHEMA_REGISTRY_IMAGE)
//                    .withNetwork(NETWORK)
//                    .withExposedPorts(8081)
//                    .withEnv("SCHEMA_REGISTRY_HOST_NAME", "schema-registry")
//                    .withEnv("SCHEMA_REGISTRY_LISTENERS", "http://0.0.0.0:8081")
//                    .withEnv("SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS",
//                            "PLAINTEXT://" + KAFKA_CONTAINER.getNetworkAliases().get(0) + ":9092")
//                    .waitingFor(Wait.forHttp("/subjects").forStatusCode(200));
    @Container
    public static DockerComposeContainer<?> dockerComposeContainer =
            new DockerComposeContainer<>(new File("src/test/resources/docker-compose-test.yml"))
                    .withExposedService("broker", 9092)
                    .withExposedService("schema-registry", 8081);

//    private static final KafkaContainer kafkaContainer = new KafkaContainer(KAFKA_IMAGE)
//            .withAccessToHost(true);
//            .withEnv("CLUSTER_ID", "MkU3OEVBNTcwNTJENDM2Qk")
//            .withEnv("KAFKA_LOG_DIRS", "/tmp/kraft-combined-logs")
//            .withEnv("KAFKA_CONTROLLER_LISTENER_NAMES", "CONTROLLER")
//            .withEnv("KAFKA_CONTROLLER_LISTENER_NAMES", "CONTROLLER")
//            .withEnv("KAFKA_LISTENERS", "PLAINTEXT://broker:29092,CONTROLLER://broker:29093,PLAINTEXT_HOST://0.0.0.0:9093")
//            .withEnv("KAFKA_CONTROLLER_QUORUM_VOTERS", "1@broker:29093")
//            .withEnv("KAFKA_PROCESS_ROLES", "broker,controller")
//            .withEnv("KAFKA_JMX_HOSTNAME", "localhost")
//            .withEnv("KAFKA_JMX_PORT", "9101")
//            .withEnv("KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR", "1")
//            .withEnv("KAFKA_TRANSACTION_STATE_LOG_MIN_ISR", "1")
//            .withEnv("KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS", "0")
//            .withEnv("KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR", "1")
//            .withEnv("KAFKA_ADVERTISED_LISTENERS", "PLAINTEXT://broker:29092,PLAINTEXT_HOST://localhost:9093")
//            .withEnv("KAFKA_LISTENER_SECURITY_PROTOCOL_MAP", "CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT")
//            .withEnv("KAFKA_NODE_ID", "1")
//            .withEnv("KAFKA_INTER_BROKER_LISTENER_NAME", "PLAINTEXT");

//    private static final GenericContainer<?> schemaRegistryContainer = new GenericContainer<>(SCHEMA_REGISTRY_IMAGE)
//            .withExposedPorts(8081)
//            .dependsOn(kafkaContainer)
//            .withEnv("SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS", "PLAINTEXT://localhost:59254")
//            .withAccessToHost(true);
    //    SCHEMA_REGISTRY_KAFKASTORE_CONNECTION_URL,SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS
    //            .withEnv("SCHEMA_REGISTRY_HOST_NAME", "schema-registry")
    //            .withEnv("SCHEMA_REGISTRY_LISTENERS", "http://0.0.0.0:8081");
//    kafkaContainer.getExposedPorts() -> [2181, 9093]

    @DynamicPropertySource
    static void kafkaProperties(DynamicPropertyRegistry registry) {

//        registry.add("spring.kafka.bootstrap-servers", KAFKA_CONTAINER::getBootstrapServers);
//        registry.add("spring.kafka.properties.schema.registry.url", () ->
//                "http://" + SCHEMA_REGISTRY.getHost() + ":" + SCHEMA_REGISTRY.getFirstMappedPort());

        registry.add("spring.kafka.bootstrap-servers", () -> "localhost:" + dockerComposeContainer.getServicePort("broker", 9092));
        registry.add("spring.kafka.properties.schema.registry.url", () -> "http://localhost:" + dockerComposeContainer.getServicePort("schema-registry", 8081));
    }


//    @DynamicPropertySource
//    static void kafkaProperties(DynamicPropertyRegistry registry) {
//        kafkaContainer.start();
//
//        await().atMost(Duration.ofSeconds(30)).until(kafkaContainer::isRunning);
//
//        schemaRegistryContainer.start();
//        List<Integer> boundPortNumbers = kafkaContainer.getBoundPortNumbers();
//        log.info("Kafka bound port numbers: {}", boundPortNumbers);
//        log.info("Kafka bootstrap servers: {}", kafkaContainer.getBootstrapServers());
////        log.info("Schema Registry URL: {}", "http://" + schemaRegistryContainer.getHost() + ":" + schemaRegistryContainer.getMappedPort(8081));
//
//        registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
//
//        //        kafkaContainer.getFirstMappedPort() -> 29092
////        kafkaContainer.getHost() -> localhost
//
//
////        registry.add("spring.kafka.properties.schema.registry.url", () ->
////                "http://" + schemaRegistryContainer.getHost() + ":" + schemaRegistryContainer.getMappedPort(8081));
//    }


}
