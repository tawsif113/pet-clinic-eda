package com.edapoc.appointment.repository;

import com.edapoc.appointment.domain.AppointmentAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentAggregate, Long> {

}
