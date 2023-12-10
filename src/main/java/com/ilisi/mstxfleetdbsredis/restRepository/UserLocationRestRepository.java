package com.ilisi.mstxfleetdbsredis.restRepository;

import com.ilisi.mstxfleetdbsredis.model.UserLocation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserLocationRestRepository extends CrudRepository<UserLocation, String> {

    Optional<UserLocation> findByUserId(String userId);

}
