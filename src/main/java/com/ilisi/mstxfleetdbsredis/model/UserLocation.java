package com.ilisi.mstxfleetdbsredis.model;

import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;

@RedisHash("ActiveUserLocation")
public record UserLocation(
        String id,
        String userId,
        double latitude,
        double longitude,
        Instant createdAt) {
}
