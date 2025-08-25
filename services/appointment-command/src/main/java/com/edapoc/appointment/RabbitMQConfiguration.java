package com.edapoc.appointment;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
  public static final String EXCHANGE_NAME = "pet-clinic-exchange";
  public static final String APPOINTMENT_QUEUE = "appointment-scheduled-queue";
  public static final String PET_CREATED_QUEUE = "pet-created-queue";
  public static final String APPOINTMENT_ROUTING_KEY = "appointments.scheduled";
  public static final String PET_CREATED_ROUTING_KEY = "pet.created";
}
