package com.losnullpointer.elgranpostor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.losnullpointer.elgranpostor.model")
@EnableJpaRepositories("com.losnullpointer.elgranpostor.persistence.jpa")
public class SubastasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubastasApplication.class, args);
    }

}
