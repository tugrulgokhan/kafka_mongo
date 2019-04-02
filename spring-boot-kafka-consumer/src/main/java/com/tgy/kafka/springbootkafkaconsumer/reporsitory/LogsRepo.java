package com.tgy.kafka.springbootkafkaconsumer.reporsitory;

import com.tgy.kafka.springbootkafkaconsumer.model.Logs;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LogsRepo extends MongoRepository<Logs, String> {

//
}
