package com.example.diploma.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.Set;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true)
public class Vehicle extends BaseEntity {

    @Column(name = "license_plate", nullable = false, unique = true)
    @NotEmpty
    @Size(max = 12)
    private String licensePlate;

    @Column(name = "color")
    @Size(max = 128)
    private String color;

    @Column(name = "brand")
    @Size(max = 128)
    private String brand;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "vehicle_class", joinColumns = @JoinColumn(name = "vehicle_id"))
    @Column(name = "transport_class")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<TransportClass> transportClass;
}
