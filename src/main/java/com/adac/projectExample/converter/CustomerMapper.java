package com.adac.projectExample.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.adac.projectExample.model.Customer;
import com.adac.projectExample.request.NewCustomerRequest;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	@Mapping(target = "id", ignore = true)
	Customer NewCustomerRequestToCustomerConvert(NewCustomerRequest request);
	
}
