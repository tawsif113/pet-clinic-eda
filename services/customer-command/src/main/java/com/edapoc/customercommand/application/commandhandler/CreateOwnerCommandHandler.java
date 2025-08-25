package com.edapoc.customercommand.application.commandhandler;

import com.edapoc.customercommand.application.command.CreateOwnerCommand;
import com.edapoc.customercommand.application.mapper.OwnerMapper;
import com.edapoc.customercommand.application.service.OwnerService;
import com.edapoc.customercommand.controller.dto.OwnerCreateResponse;
import com.edapoc.customercommand.domain.OwnerAggregate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateOwnerCommandHandler {

  private final OwnerService ownerService;
  private final OwnerMapper ownerMapper;

  public OwnerCreateResponse handle(CreateOwnerCommand createOwnerCommand) {

    OwnerAggregate createOwner = OwnerAggregate.create(createOwnerCommand);

    ownerService.persistOwner(createOwner);

    //publish event

    return ownerMapper.toResponse(createOwner);
  }
}
