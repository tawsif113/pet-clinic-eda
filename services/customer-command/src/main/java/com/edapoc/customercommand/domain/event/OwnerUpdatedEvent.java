package com.edapoc.customercommand.domain.event;

import java.time.Instant;

public record OwnerUpdatedEvent(
    Long ownerId,
    String name,
    String email,
    String eventId,
    String correlationId,
    Instant occurredOn
) {}
