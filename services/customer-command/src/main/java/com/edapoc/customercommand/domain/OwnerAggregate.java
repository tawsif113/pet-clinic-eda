package com.edapoc.customercommand.domain;

import com.edapoc.customercommand.application.command.CreateOwnerCommand;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "owner")
public class OwnerAggregate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String address;
  private String mail;
  private String telephone;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<PetAggregate> pets = new HashSet<>();


  public static OwnerAggregate create(CreateOwnerCommand createOwnerCommand){
    validateOwnerCommand(createOwnerCommand);

    OwnerAggregate ownerAggregate = new OwnerAggregate();
    ownerAggregate.setName(createOwnerCommand.getName());
    ownerAggregate.setAddress(createOwnerCommand.getAddress());
    ownerAggregate.setMail(createOwnerCommand.getMail());
    ownerAggregate.setTelephone(createOwnerCommand.getTelephone());

    return ownerAggregate;
  }

  public PetAggregate addPet(String petName, String petType) {
    PetAggregate petAggregate = new PetAggregate();
    petAggregate.setName(petName);
    petAggregate.setType(petType);
    petAggregate.setOwner(this);
    this.pets.add(petAggregate);
    return petAggregate;
  }

  private static void validateOwnerCommand(CreateOwnerCommand createOwnerCommand) {
    if ( createOwnerCommand.getName() == null || createOwnerCommand.getName().isEmpty() ) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if ( createOwnerCommand.getAddress() == null || createOwnerCommand.getAddress().isEmpty() ) {
      throw new IllegalArgumentException("Address cannot be null or empty");
    }
    if ( createOwnerCommand.getMail() == null || createOwnerCommand.getMail().isEmpty() ) {
      throw new IllegalArgumentException("Mail cannot be null or empty");
    }
    if ( createOwnerCommand.getTelephone() == null || createOwnerCommand.getTelephone().isEmpty() ) {
      throw new IllegalArgumentException("Telephone cannot be null or empty");
    }
  }
}
