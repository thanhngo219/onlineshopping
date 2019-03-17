package com.thanh.shopping.shoppingcart.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.shoppingcart.domain.Product;
import com.thanh.shopping.shoppingcart.domain.ShoppingCartLine;
import com.thanh.shopping.shoppingcart.dto.CartLineDTO;
import com.thanh.shopping.shoppingcart.dto.ProductDTO;

@Service
@Qualifier("cartLineMapper")
public class CartLineMapper implements DtoMapper<ShoppingCartLine, CartLineDTO> {
	
	@Autowired
	@Qualifier("cartProductMapper")
	private DtoMapper<Product, ProductDTO> dtoMapper;

	@Override
	public CartLineDTO toDTO(ShoppingCartLine scl) {
		return new CartLineDTO(dtoMapper.toDTO(scl.getProduct()), scl.getQuantity());
	}

	@Override
	public ShoppingCartLine toEntity(CartLineDTO v) {
		// TODO Auto-generated method stub
		return null;
	}

}
