package com.ilisi.mstxfleetdbsredis.restRepository;

import com.ilisi.mstxfleetdbsredis.model.UserLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "userLocation", path = "userLocation")
public interface UserLocationRestRepository extends CrudRepository<UserLocation, String> {

    Optional<UserLocation> findByUserId(String userId);
}
