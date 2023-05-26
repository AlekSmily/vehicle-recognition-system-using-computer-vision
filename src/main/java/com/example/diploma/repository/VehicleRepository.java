package com.example.diploma.repository;

import com.example.diploma.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @RestResource(rel = "by-licensePlate", path = "by-licensePlate")
    Optional<Vehicle> findByLicensePlate(String licensePlate);
}
