package com.edapoc.customercommand.application.service;

import com.edapoc.customercommand.application.command.CreatePetCommand;
import com.edapoc.customercommand.domain.OwnerAggregate;
import com.edapoc.customercommand.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {

  private final OwnerRepository ownerRepository;

  public void persistOwner(OwnerAggregate createOwner) {
    ownerRepository.save(createOwner);
  }

  public void addPetToOwner(Long ownerId,CreatePetCommand createPetCommand) {
    OwnerAggregate owner = ownerRepository.findById(ownerId).orElseThrow(() -> new IllegalArgumentException("Owner not found"));
    owner.addPet(createPetCommand.getPetName(), createPetCommand.getPetType());
    ownerRepository.save(owner);
  }
}
