package com.edapoc.customercommand.repository;

import com.edapoc.customercommand.domain.OwnerAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerAggregate, Long> {

}
