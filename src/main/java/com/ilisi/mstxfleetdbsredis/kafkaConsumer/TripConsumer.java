package com.ilisi.mstxfleetdbsredis.kafkaConsumer;



import com.ilisi.mstxfleetdbsredis.model.Location;
import com.ilisi.mstxfleetdbsredis.model.Trip;
import com.ilisi.mstxfleetdbsredis.restRepository.TripRestRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;


@Service
@Slf4j
public class TripConsumer {


    @Autowired
    private TripRestRepository tripRestRepository;

    @KafkaListener(topics = "trip", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Map<String,Object>> record) {
        try {
            Map<String,Object> message = record.value();
            log.info("Message received from Kafka topic trip: {}", message);

            if(message.get("driverId") == null) {
                log.info("Initializing trip");
                Trip trip = Trip.builder()
                        .tripId(message.get("tripId").toString())
                        .passengerId(message.get("passengerId").toString())
                        .startLocation(new Location(Double.parseDouble(message.get("startLatitude").toString()), Double.parseDouble(message.get("startLongitude").toString())))
                        .destination(new Location(Double.parseDouble(message.get("endLatitude").toString()), Double.parseDouble(message.get("endLongitude").toString())))
                        .status(message.get("status").toString())
                        .createdAt(Instant.parse(message.get("created_at").toString()))
                        .build();
                tripRestRepository.save(trip);
            } else {
                log.info("Accepting trip");
                Trip trip = tripRestRepository.findById(message.get("passengerId").toString()).orElseThrow(
                        () -> new RuntimeException("Trip not found")
                );
                trip.setDriverId(message.get("driverId").toString());
                trip.setStatus(message.get("status").toString());
                trip.setUpdatedAt(Instant.parse(message.get("updated_at").toString()));
                tripRestRepository.save(trip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
