package com.ilisi.mstxfleetdbsredis.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;

@RedisHash("UserLocation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserLocation {

    @Id
    private String userId;
    private String location;

    private String userType;
    private boolean isOnline;

    private Instant createdAt;
    private Instant updatedAt;
}

