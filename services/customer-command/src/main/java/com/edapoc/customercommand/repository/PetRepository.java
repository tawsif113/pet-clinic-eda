package com.edapoc.customercommand.repository;

import com.edapoc.customercommand.domain.PetAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetAggregate, Long> {

}
