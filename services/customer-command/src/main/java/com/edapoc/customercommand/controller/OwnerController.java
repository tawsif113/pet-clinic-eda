package com.edapoc.customercommand.controller;

import com.edapoc.customercommand.application.command.CreateOwnerCommand;
import com.edapoc.customercommand.application.command.CreatePetCommand;
import com.edapoc.customercommand.application.commandhandler.CreateOwnerCommandHandler;
import com.edapoc.customercommand.application.commandhandler.CreatePetCommandHandler;
import com.edapoc.customercommand.controller.dto.OwnerCreateResponse;
import com.edapoc.customercommand.controller.dto.PetCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {

  private final CreateOwnerCommandHandler createOwnerCommandHandler;
  private final CreatePetCommandHandler createPetCommandHandler;

  @PostMapping
  public ResponseEntity<OwnerCreateResponse> createOwner(@RequestBody CreateOwnerCommand createOwnerCommand){
    return new ResponseEntity<>(createOwnerCommandHandler.handle(createOwnerCommand), HttpStatus.CREATED);
  }

  @PostMapping("/{id}/pets")
  public ResponseEntity<PetCreateResponse> createPet(@PathVariable Long id, @RequestBody CreatePetCommand createPetCommand){
    return new ResponseEntity<>(createPetCommandHandler.handle(id,createPetCommand), HttpStatus.CREATED);
  }

}
