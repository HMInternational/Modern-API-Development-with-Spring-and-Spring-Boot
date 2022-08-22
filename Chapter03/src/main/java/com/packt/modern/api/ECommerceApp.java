package com.packt.modern.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ECommerceApp {

    public static void main(final String[] args) {
        log.info("http://localhost:8080/swagger-ui/index.html");
        SpringApplication.run(ECommerceApp.class, args);
    }
}