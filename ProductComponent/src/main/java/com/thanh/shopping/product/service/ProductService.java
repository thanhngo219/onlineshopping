package com.thanh.shopping.product.service;

import java.util.List;

import com.thanh.shopping.product.domain.Product;
import com.thanh.shopping.product.dto.OrderedProductDTO;
import com.thanh.shopping.product.dto.ProductDTO;

public interface ProductService {
	void addProduct(ProductDTO product);
	
	ProductDTO getProductDTO(String productNumber);
	
	void setStock(Long quantity, String locationCode, String productNumber);
	
	Product getProduct(String productNumber);
	
	void updateProduct(ProductDTO product);
	
	void reduceProductInStock(List<OrderedProductDTO> orderedProductDtos);
}
