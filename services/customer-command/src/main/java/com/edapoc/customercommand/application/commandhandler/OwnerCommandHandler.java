package com.edapoc.customercommand.application.commandhandler;

import com.edapoc.customercommand.application.command.CreateOwnerCommand;
import com.edapoc.customercommand.application.command.UpdateOwnerCommand;
import com.edapoc.customercommand.domain.event.OwnerCreatedEvent;
import com.edapoc.customercommand.domain.event.OwnerUpdatedEvent;
import com.edapoc.customercommand.domain.model.Owner;
import com.edapoc.customercommand.domain.repository.OwnerRepository;
import com.edapoc.customercommand.infrastructure.messaging.EventPublisher;
import java.time.Instant;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerCommandHandler {

  private final OwnerRepository ownerRepository;
  private final EventPublisher eventPublisher;

  public void handle(CreateOwnerCommand createOwnerCommand) {
    Owner owner = Owner.create(createOwnerCommand.name(), createOwnerCommand.email());
    ownerRepository.save(owner);

    OwnerCreatedEvent event = new OwnerCreatedEvent(
        owner.getId(),
        owner.getName(),
        owner.getEmail(),
        UUID.randomUUID().toString(),
        createOwnerCommand.correlationId(),
        Instant.now()
    );
    eventPublisher.publishOwnerCreated(event);
  }

  public void handle(UpdateOwnerCommand updateOwnerCommand) {
    Owner owner = ownerRepository.findById(updateOwnerCommand.ownerId()).orElseThrow(() -> new RuntimeException("Owner not found"));
    owner.update(updateOwnerCommand.name(), updateOwnerCommand.email());
    ownerRepository.save(owner);

    OwnerUpdatedEvent event = new OwnerUpdatedEvent(
        owner.getId(),
        owner.getName(),
        owner.getEmail(),
        UUID.randomUUID().toString(),
        updateOwnerCommand.correlationId(),
        Instant.now()
    );
    eventPublisher.publishOwnerUpdated(event);
  }
}

