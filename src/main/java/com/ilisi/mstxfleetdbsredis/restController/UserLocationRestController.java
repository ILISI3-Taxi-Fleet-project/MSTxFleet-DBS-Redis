package com.ilisi.mstxfleetdbsredis.restController;

import com.ilisi.mstxfleetdbsredis.model.Trip;
import com.ilisi.mstxfleetdbsredis.model.UserLocation;
import com.ilisi.mstxfleetdbsredis.restRepository.TripRestRepository;
import com.ilisi.mstxfleetdbsredis.restRepository.UserLocationRestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserLocationRestController {

    private final TripRestRepository tripRestRepository;
    private final UserLocationRestRepository userLocationRestRepository;

    @GetMapping("/trip/findDriverInSameTrip")
    public ResponseEntity<UserLocation> findDriverInSameTrip(@RequestParam("passengerId") String passengerId) {
        Trip trip = tripRestRepository.findById(passengerId).orElseThrow(
                () -> new RuntimeException("Trip not found")
        );

        UserLocation userLocation = userLocationRestRepository.findById(trip.getDriverId()).orElseThrow(
                () -> new RuntimeException("Driver not found")
        );
        return ResponseEntity.ok(userLocation);
    }

    @GetMapping("/userLocations/getMultiLocations")
    public ResponseEntity<List<UserLocation>> getPassengerLocations(@RequestParam("passengerIds") Collection<String> passengerIds) {
        List<UserLocation> userLocations = new ArrayList<>();
        passengerIds.forEach(s -> {
            UserLocation userLocation = userLocationRestRepository.findById(s).orElseThrow(
                    () -> new RuntimeException("Passenger not found")
            );
            userLocations.add(userLocation);
        });
        return ResponseEntity.ok(userLocations);
    }
}
