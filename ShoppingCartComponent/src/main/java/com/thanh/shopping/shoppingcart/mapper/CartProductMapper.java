package com.thanh.shopping.shoppingcart.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.shoppingcart.domain.Product;
import com.thanh.shopping.shoppingcart.dto.ProductDTO;

@Service
@Qualifier("cartProductMapper")
public class CartProductMapper implements DtoMapper<Product, ProductDTO> {
	
	@Override
	public ProductDTO toDTO(Product p) {
		return new ProductDTO(p.getProductNumber(), p.getName(), p.getPrice());
	}

	@Override
	public Product toEntity(ProductDTO v) {
		// TODO Auto-generated method stub
		return null;
	}

}
