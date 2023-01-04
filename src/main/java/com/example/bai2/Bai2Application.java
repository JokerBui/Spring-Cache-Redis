package com.example.bai2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@Slf4j
public class Bai2Application {

    public static void main(String[] args) {
        SpringApplication.run(Bai2Application.class, args);
    }

}
