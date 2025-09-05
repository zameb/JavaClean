package com.kipuig.eventreminder.config;

import com.kipuig.eventreminder.application.interfaces.EventRepository;
import com.kipuig.eventreminder.application.interfaces.PlanTypeRepository;
import com.kipuig.eventreminder.application.interfaces.SubscriptionRepository;
import com.kipuig.eventreminder.application.interfaces.UserRepository;
import com.kipuig.eventreminder.infrastructure.persistence.implementation.JpaEventRepositoryImpl;
import com.kipuig.eventreminder.infrastructure.persistence.implementation.JpaPlanTypeRepositoryImpl;
import com.kipuig.eventreminder.infrastructure.persistence.implementation.JpaSubscriptionRepositoryImpl;
import com.kipuig.eventreminder.infrastructure.persistence.implementation.JpaUserRepositoryImpl;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaEventRepository;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaPlanTypeRepository;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaSubscriptionRepository;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaUserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.kipuig.eventreminder.infrastructure.persistence.interfaces")
@EntityScan("com.kipuig.eventreminder.infrastructure.persistence.entities")
@ComponentScan("com.kipuig.eventreminder.application.services")
public class TestDatabaseConfig {
    @Bean
    public UserRepository userRepository(JpaUserRepository jpaUserRepository) {
        return new JpaUserRepositoryImpl(jpaUserRepository);
    }
    
    @Bean
    public EventRepository eventRepository(JpaEventRepository jpaEventRepository) {
        return new JpaEventRepositoryImpl(jpaEventRepository);
    }
    
    @Bean
    public PlanTypeRepository planTypeRepository(JpaPlanTypeRepository jpaPlanTypeRepository) {
        return new JpaPlanTypeRepositoryImpl(jpaPlanTypeRepository);
    }
    
    @Bean
    public SubscriptionRepository subscriptionRepository(JpaSubscriptionRepository jpaSubscriptionRepository) {
        return new JpaSubscriptionRepositoryImpl(jpaSubscriptionRepository);
    }
}