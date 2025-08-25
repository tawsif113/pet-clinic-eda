package com.edapoc.customercommand.application.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePetCommand {
  private String petName;
  private String petType;
}
