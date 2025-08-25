package com.edapoc.customercommand.application.commandhandler;

import com.edapoc.customercommand.application.command.CreatePetCommand;
import com.edapoc.customercommand.application.mapper.PetMapper;
import com.edapoc.customercommand.application.service.OwnerService;
import com.edapoc.customercommand.controller.dto.PetCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePetCommandHandler {

  private final OwnerService ownerService;
  private final PetMapper petMapper;

  public PetCreateResponse handle(Long ownerId,CreatePetCommand createPetCommand) {
    ownerService.addPetToOwner(ownerId,createPetCommand);
    //publish event
    return petMapper.toResponse(createPetCommand);
  }

}
