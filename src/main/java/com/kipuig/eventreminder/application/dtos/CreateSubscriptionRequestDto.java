package com.kipuig.eventreminder.application.dtos;

import java.util.UUID;

public record CreateSubscriptionRequestDto(UUID userId, UUID eventId){}
