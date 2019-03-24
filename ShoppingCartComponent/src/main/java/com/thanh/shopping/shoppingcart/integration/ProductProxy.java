package com.thanh.shopping.shoppingcart.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.thanh.shopping.shoppingcart.dto.ProductDTO;

@Component
public class ProductProxy {
	
	@Autowired
	private RestOperations restTemplate;
	
	@Value("${product.url}")
	String productsURL;
	
	public ProductDTO getProduct(String productNumber) {
		ProductDTO product = restTemplate.getForObject(productsURL + "/product/" + productNumber, ProductDTO.class);
		return product;
	};
}
