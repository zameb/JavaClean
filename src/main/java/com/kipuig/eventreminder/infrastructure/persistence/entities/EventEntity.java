package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "Events")
public class EventEntity {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    private String name;
    private ZonedDateTime dateTime;
    
    public EventEntity() {
    }
    
    public EventEntity(UUID id, String name, ZonedDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
    }
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ZonedDateTime getDateTime() {
        return dateTime;
    }
    
    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
