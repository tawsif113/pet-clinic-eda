package com.edapoc.customercommand.application.mapper;

import com.edapoc.customercommand.application.command.CreatePetCommand;
import com.edapoc.customercommand.controller.dto.PetCreateResponse;
import org.springframework.stereotype.Component;

@Component
public interface PetMapper {

  PetCreateResponse toResponse(CreatePetCommand createPetCommand);
}
