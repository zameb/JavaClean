package com.kipuig.eventreminder.presentation.support;

import java.time.Instant;

public record ErrorResponse(
    String message,
    String details, 
    Instant timestamp
) {
    public ErrorResponse(String message, String details) {
        this(message, details, Instant.now());
    }
    
    public ErrorResponse(String message) {
        this(message, null, Instant.now());
    }
}
