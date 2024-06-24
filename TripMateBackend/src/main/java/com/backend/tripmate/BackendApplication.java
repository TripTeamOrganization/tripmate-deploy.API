package com.backend.tripmate;

import com.backend.tripmate.importabledata.MyImportServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner importDataRunner(MyImportServiceClient importServiceClient) {
        return args -> {
           importServiceClient.importActivities();
           importServiceClient.importAccommodations();
           importServiceClient.importRestaurants();
           importServiceClient.importFlights();
        };
    }
}