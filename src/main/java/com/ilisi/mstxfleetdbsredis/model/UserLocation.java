package com.ilisi.mstxfleetdbsredis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;

@RedisHash("ActiveUserLocation")
public record UserLocation(
        @Id
        String userId,
        String location,
        String userType,
        Boolean isOnline,
        Instant creationAt) {
}
