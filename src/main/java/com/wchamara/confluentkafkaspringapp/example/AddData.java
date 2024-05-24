package com.wchamara.confluentkafkaspringapp.example;

import com.wchamara.confluentkafkaspringapp.dto.PoemValue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AddData {

    private final AvroProducer producer;

    public AddData(AvroProducer producer) {
        this.producer = producer;
    }
    @Bean
    public CommandLineRunner runner () {
        return (args) -> {
            System.out.println("Start adding data to Kafka");
            PoemValue poem1 = PoemValue.newBuilder()
                    .setTitle("Roses are red, violets are blue")
                    .build();
            producer.sendMessage("1", poem1);

            PoemValue poem2 = PoemValue.newBuilder()
                    .setTitle("I am a poet, and I know it")
                    .build();

            producer.sendMessage("2", poem2);

            PoemValue poem3 = PoemValue.newBuilder()
                    .setTitle("I am a poet, and I know it")
                    .build();

            producer.sendMessage("3", poem3);

            PoemValue poem4 = PoemValue.newBuilder()
                    .setTitle("I am a poet, and I know it")
                    .build();

            producer.sendMessage("4", poem4);

            PoemValue poem5 = PoemValue.newBuilder()
                    .setTitle("I am a poet, and I know it")
                    .build();

            producer.sendMessage("5", poem5);

            PoemValue poem6 = PoemValue.newBuilder()
                    .setTitle("I am a poet, and I know it")
                    .build();

            producer.sendMessage("6", poem6);

            PoemValue poem7 = PoemValue.newBuilder()
                    .setTitle("I am a poet, and I know it")
                    .build();

            producer.sendMessage("7", poem7);

            PoemValue poem8 = PoemValue.newBuilder()
                    .setTitle("I am a poet, and I know it")
                    .build();

            producer.sendMessage("8", poem8);

            PoemValue poem9 = PoemValue.newBuilder()
                    .setTitle("I am a poet, and I know it")
                    .build();

            producer.sendMessage("9", poem9);

            PoemValue poem10 = PoemValue.newBuilder()
                    .setTitle("I am a poet, and I know it")
                    .build();

            producer.sendMessage("10", poem10);
        };
    }


}
