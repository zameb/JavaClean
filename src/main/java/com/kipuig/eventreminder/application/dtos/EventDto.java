package com.kipuig.eventreminder.application.dtos;

import java.time.ZonedDateTime;
import java.util.UUID;

public record EventDto(UUID id, String name, ZonedDateTime dateTime) {

}
