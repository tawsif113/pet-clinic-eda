package com.edapoc.customercommand.application.mapper;

import com.edapoc.customercommand.controller.dto.OwnerCreateResponse;
import com.edapoc.customercommand.domain.OwnerAggregate;

public interface OwnerMapper {
  OwnerCreateResponse toResponse(OwnerAggregate createOwner);
}
