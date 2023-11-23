package com.ilisi.mstxfleetdbsredis.restRepository;

import com.ilisi.mstxfleetdbsredis.model.UserLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "activeUserLocations", path = "activeUserLocations")
public interface ActiveUserLocation  extends CrudRepository<UserLocation, String> {
}
