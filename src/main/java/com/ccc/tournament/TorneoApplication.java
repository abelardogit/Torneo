package com.ccc.tournament;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TorneoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TorneoApplication.class, args);
    }
    @Bean
    CommandLineRunner init(com.ccc.tournament.shared.storagefiles.domain.interfaces.StorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }

}
