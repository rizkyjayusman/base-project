package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class MainApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApiApplication.class, args);
    }
}
