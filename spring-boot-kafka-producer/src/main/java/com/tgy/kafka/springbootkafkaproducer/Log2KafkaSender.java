package com.tgy.kafka.springbootkafkaproducer;

import com.tgy.kafka.springbootkafkaproducer.model.Logs;
import com.tgy.kafka.springbootkafkaproducer.resource.MyFileReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Log2KafkaSender {

    @Autowired
    private KafkaTemplate<String, Logs> kafkaTemplate;

    private static final Logger LOG = Logger.getLogger(Log2KafkaSender.class);
    private static MyFileReader reader = null;

    private static final String topic = "LogTopic";

    @Scheduled(fixedRate = 100)
    public void create() {
        if(reader == null){
            try {
                reader = new MyFileReader("C:\\Users" +
                        "\\TugrulGokhan\\Downloads\\" +
                        "project_teb\\log-creator\\logging.log");
            } catch (IOException e) {
                LOG.error("No such file baby");
                return;
            }
        }
        Logs log;
        try {
            log = reader.readLine();
        } catch (IOException e) {
            LOG.error("No such read access baby");
            return;
        }
        if(log == null){
            reader.closeReader();
            reader = null;
            return;
        }


        LOG.info(log.toString());
        kafkaTemplate.send(topic, log);

    }

}