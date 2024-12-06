package com.adac.projectExample.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.adac.projectExample.model.Product;
import com.adac.projectExample.request.NewProductRequest;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	@Mapping(target = "id", ignore = true)
	Product newProductRequestToProductConvert(NewProductRequest request);
	
}
