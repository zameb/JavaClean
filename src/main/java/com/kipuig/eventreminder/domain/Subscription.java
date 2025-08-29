package com.kipuig.eventreminder.domain;

import java.util.UUID;

public class Subscription {
    private final UUID id;
    private final String name;

    public Subscription(UUID id, String name) {

        if (name == null) {
            throw new IllegalArgumentException("Nombre inválido");
        }

        this.id = id != null ? id : UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
