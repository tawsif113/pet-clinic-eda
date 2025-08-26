package com.edapoc.customercommand.domain.repository;

import com.edapoc.customercommand.domain.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
