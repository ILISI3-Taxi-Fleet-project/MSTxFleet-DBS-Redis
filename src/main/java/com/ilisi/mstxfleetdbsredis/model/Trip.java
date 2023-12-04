package com.ilisi.mstxfleetdbsredis.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;

@RedisHash("Trip")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Trip {

    private String tripId;

    private String status;

    private Location destination;

    private Location startLocation;

    private Instant createdAt;

    private Instant updatedAt;

    @Id
    private String passengerId;

    private String driverId;
}
