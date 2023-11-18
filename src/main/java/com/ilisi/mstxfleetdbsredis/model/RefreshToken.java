package com.ilisi.mstxfleetdbsredis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;

@RedisHash("RefreshToken")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {
    private String id;

    private String token;
    private String userId;
    private Instant expiration;
    private Instant issuedAt;
}
