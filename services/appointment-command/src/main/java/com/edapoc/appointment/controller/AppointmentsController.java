package com.edapoc.appointment.controller;

import com.edapoc.appointment.application.command.ScheduleAppointmentCommand;
import com.edapoc.appointment.application.command.handler.ScheduleAppointmentCommandHandler;
import com.edapoc.appointment.application.query.GetAppointmentQuery;
import com.edapoc.appointment.application.query.handler.AppointmentQueryHandler;
import com.edapoc.appointment.domain.AppointmentAggregate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentsController {
  private final ScheduleAppointmentCommandHandler scheduleAppointmentCommandHandler;
  private final AppointmentQueryHandler appointmentQueryHandler;

  @PostMapping
  public ResponseEntity<AppointmentAggregate> scheduleAppointment(@RequestBody ScheduleAppointmentCommand command) {
    return new ResponseEntity<>(scheduleAppointmentCommandHandler.handle(command), HttpStatus.CREATED);
  }

  @GetMapping("/{appointmentId}")
  public ResponseEntity<AppointmentAggregate> getAppointment(@PathVariable Long appointmentId) {
    return appointmentQueryHandler.handle(new GetAppointmentQuery(appointmentId))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }
}
