package com.thanh.shopping.shoppingcart.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.shoppingcart.domain.ShoppingCart;
import com.thanh.shopping.shoppingcart.domain.ShoppingCartLine;
import com.thanh.shopping.shoppingcart.dto.CartLineDTO;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;

@Service
@Qualifier("shoppingCartMapper")
public class ShoppingCartMapper implements DtoMapper<ShoppingCart, ShoppingCartDTO> {

	@Autowired
	@Qualifier("cartLineMapper")
	private DtoMapper<ShoppingCartLine, CartLineDTO> dtoMapper;
	
	@Override
	public ShoppingCartDTO toDTO(ShoppingCart sc) {
		ShoppingCartDTO result = new ShoppingCartDTO(sc.getCartId());
		for(ShoppingCartLine scl : sc.getCartLines()) {
			result.addToCartLines(dtoMapper.toDTO(scl));
		}
		return result;
	}

	@Override
	public ShoppingCart toEntity(ShoppingCartDTO v) {
		// TODO Auto-generated method stub
		return null;
	}

}
