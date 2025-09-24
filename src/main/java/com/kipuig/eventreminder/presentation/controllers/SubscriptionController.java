package com.kipuig.eventreminder.presentation.controllers;

import com.kipuig.eventreminder.application.dtos.CreateSubscriptionRequestDto;
import com.kipuig.eventreminder.application.dtos.CreateSubscriptionResponseDto;
import com.kipuig.eventreminder.application.services.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<CreateSubscriptionResponseDto> createSubscription(
            @RequestBody CreateSubscriptionRequestDto request) {

        var subscriptionId = subscriptionService.createSubscription(
                request.userId(),
                request.eventId()
        );

        return ResponseEntity.ok(new CreateSubscriptionResponseDto(subscriptionId));
    }
}
