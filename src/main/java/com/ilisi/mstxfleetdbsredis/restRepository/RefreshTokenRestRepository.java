package com.ilisi.mstxfleetdbsredis.restRepository;


import com.ilisi.mstxfleetdbsredis.model.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "refreshToken", path = "refreshToken")
public interface RefreshTokenRestRepository extends CrudRepository<RefreshToken, String> {
}
