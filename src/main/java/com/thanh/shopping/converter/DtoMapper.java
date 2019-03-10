package com.thanh.shopping.converter;

import com.thanh.shopping.domain.BaseEntity;
import com.thanh.shopping.order.dto.BaseDTO;

public interface DtoMapper<U extends BaseEntity, V extends BaseDTO> {
	V toDTO(U u);
	
	U toEntity(V v);
}
