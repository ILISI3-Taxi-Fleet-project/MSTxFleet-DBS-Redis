package com.ilisi.mstxfleetdbsredis.kafkalistiner;



import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "trip", partitions = {"0"})
            ,groupId="{spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Map<String,Object>> record) {
        try {
            Map<String,Object> message = record.value();
            log.info("Message received from Kafka topic trip: {}", message);

            if(message.get("driverId") == null) {
                log.info("Initializing trip");
            } else {
                log.info("Accepting trip");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
