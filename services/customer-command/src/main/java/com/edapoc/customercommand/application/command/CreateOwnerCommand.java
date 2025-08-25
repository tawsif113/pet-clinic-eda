package com.edapoc.customercommand.application.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOwnerCommand {
  private String name;
  private String address;
  private String mail;
  private String telephone;
}
