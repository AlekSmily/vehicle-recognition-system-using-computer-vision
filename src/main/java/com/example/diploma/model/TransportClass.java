package com.example.diploma.model;

import org.springframework.security.core.GrantedAuthority;

public enum TransportClass implements GrantedAuthority {
    SEDAN,
    HATCHBACK,
    SUV,
    COUPE,
    CONVERTIBLE,
    MINIVAN,
    PICKUP,
    ESTATE,
    SPORTS,
    COMPACT,
    OFF_ROAD,
    VAN,
    CROSSOVER,
    ROADSTER,
    MUSCLE_CAR,
    MICROCAR,
    VINTAGE,
    UNIDENTIFIED;

    @Override
    public String getAuthority() {
        return name();
    }
}
