package com.github.sysfutex.holidaycamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HolidayCampApplication {
    public static void main(String[] args) {
        SpringApplication.run(HolidayCampApplication.class, args);
    }
}
