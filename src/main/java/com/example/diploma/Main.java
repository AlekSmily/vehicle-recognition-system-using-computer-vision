package com.example.diploma;

import lombok.AllArgsConstructor;
import nu.pattern.OpenCV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        OpenCV.loadLocally();
    }
}
