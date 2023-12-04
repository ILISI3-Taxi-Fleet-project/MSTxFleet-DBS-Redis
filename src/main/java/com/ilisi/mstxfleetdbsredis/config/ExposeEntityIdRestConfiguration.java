package com.ilisi.mstxfleetdbsredis.config;

import com.ilisi.mstxfleetdbsredis.model.RefreshToken;
import com.ilisi.mstxfleetdbsredis.model.Trip;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ExposeEntityIdRestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Trip.class);
        config.exposeIdsFor(RefreshToken.class);
    }
}