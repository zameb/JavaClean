package com.kipuig.eventreminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.kipuig.eventreminder.infrastructure.persistence.interfaces")
@EntityScan("com.kipuig.eventreminder.infrastructure.persistence.entities")
@ComponentScan("com.kipuig.eventreminder")
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
