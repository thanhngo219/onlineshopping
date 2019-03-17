package com.thanh.shopping.product.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.product.domain.Product;
import com.thanh.shopping.product.domain.Stock;
import com.thanh.shopping.product.dto.ProductDTO;
import com.thanh.shopping.product.dto.StockDTO;

@Service
@Qualifier("productMapper")
public class ProductMapper implements DtoMapper<Product, ProductDTO> {
	
	@Autowired
	@Qualifier("stockMapper")
	private DtoMapper<Stock, StockDTO> dtoMapper;

	@Override
	public ProductDTO toDTO(Product p) {
		ProductDTO result = new ProductDTO();
		if (p == null) {
			return null;
		}
		result.setProductNumber(p.getProductNumber());
		result.setName(p.getName());
		result.setDescription(p.getDescription());
		result.setPrice(p.getPrice());
		if (p.getStock() != null) {
			result.setStock(dtoMapper.toDTO(p.getStock()));
		}
		return result;
	}

	@Override
	public Product toEntity(ProductDTO dto) {
		Product product = new Product();
		product.setProductNumber(dto.getProductNumber());
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product.setDescription(dto.getDescription());
		return product;
	}

}
