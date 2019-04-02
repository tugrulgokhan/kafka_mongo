package com.tgy.kafka.springbootkafkaconsumer.listener;

import com.tgy.kafka.springbootkafkaconsumer.model.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private MongoTemplate mongoTemplate;

    @KafkaListener(topics = "Kafka_Example", group = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "LogTopic", group = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(Logs log) {
        System.out.println("Consumed JSON Message: " + log);
        mongoTemplate.save(log);
    }
}
