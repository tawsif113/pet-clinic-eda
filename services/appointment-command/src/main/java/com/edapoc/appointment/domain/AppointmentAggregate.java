package com.edapoc.appointment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "appointments")
public class AppointmentAggregate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long appointmentId;

  private Long petId;
  private Long customerId;
  private LocalDateTime appointmentTime;
  private String status;

  public AppointmentAggregate(Long customerId, Long petId, LocalDateTime appointmentTime, String status) {
    this.customerId = customerId;
    this.petId = petId;
    this.appointmentTime = appointmentTime;
    this.status = status;
  }

  public AppointmentAggregate() {
  }

}
