package com.example.diploma;

import com.example.diploma.repository.UserRepository;
import com.example.diploma.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class Main implements ApplicationRunner {
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(userRepository.findAll());
        System.out.println(userRepository.findByLastNameContainingIgnoreCase("last_name"));
        System.out.println(userRepository.findByEmailIgnoreCase("admin@gmail.com"));
        System.out.println(vehicleRepository.findByLicensePlate("АА5508ЕР"));
    }
}
