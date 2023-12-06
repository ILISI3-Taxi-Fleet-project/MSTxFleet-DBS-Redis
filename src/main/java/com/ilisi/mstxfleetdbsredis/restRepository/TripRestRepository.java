package com.ilisi.mstxfleetdbsredis.restRepository;


import com.ilisi.mstxfleetdbsredis.model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "trip", path = "trip")
public interface TripRestRepository extends CrudRepository<Trip, String> {
}
