package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ru.job4j.controller.ClientController;

@SpringBootApplication
public class Job4jPassportClientApplication {

    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Job4jPassportClientApplication.class, args);
    }

}
