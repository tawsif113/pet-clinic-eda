package com.edapoc.customercommand.infrastructure.messaging;

import com.edapoc.customercommand.domain.event.OwnerCreatedEvent;
import com.edapoc.customercommand.domain.event.OwnerUpdatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

  private final RabbitTemplate rabbitTemplate;

  public EventPublisher(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void publishOwnerCreated(OwnerCreatedEvent event) {
    rabbitTemplate.convertAndSend(
        RabbitMQConstants.CUSTOMER_EXCHANGE,
        RabbitMQConstants.OWNER_CREATED_QUERY_ROUTING_KEY,
        event
    );
  }

  public void publishOwnerUpdated(OwnerUpdatedEvent event) {
    rabbitTemplate.convertAndSend(
        RabbitMQConstants.CUSTOMER_EXCHANGE,
        RabbitMQConstants.OWNER_UPDATED_QUERY_ROUTING_KEY,
        event
    );
  }
}
