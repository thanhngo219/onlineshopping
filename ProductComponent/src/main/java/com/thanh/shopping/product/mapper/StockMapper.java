package com.thanh.shopping.product.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.product.domain.Stock;
import com.thanh.shopping.product.dto.StockDTO;

@Service
@Qualifier("stockMapper")
public class StockMapper implements DtoMapper<Stock, StockDTO> {

	@Override
	public StockDTO toDTO(Stock s) {
		return new StockDTO(s.getLocationCode(), s.getQuantity());
	}

	@Override
	public Stock toEntity(StockDTO v) {
		// TODO Auto-generated method stub
		return null;
	}

}
