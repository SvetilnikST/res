package com.svetilnik.res;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class ResApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(ResApplication.class, args);
    }

}
