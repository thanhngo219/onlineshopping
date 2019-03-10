package com.thanh.shopping.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thanh.shopping.converter.DtoConverter;
import com.thanh.shopping.order.dto.StockDTO;
import com.thanh.shopping.product.domain.Product;
import com.thanh.shopping.product.dto.ProductDTO;
import com.thanh.shopping.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "product/{productNumber}", method = RequestMethod.GET)
	public ResponseEntity<?> getProductByPath(@PathVariable(value = "productNumber") String productNumber) {
		Product product = productService.getProduct(productNumber);
		ProductDTO result = DtoConverter.productToDTO(product);
		return new ResponseEntity<ProductDTO>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "products", method = RequestMethod.GET)
	public ResponseEntity<?> getProductByParams(@RequestParam(value = "productNumber") String productNumber) {
		Product product = productService.getProduct(productNumber);
		ProductDTO result = DtoConverter.productToDTO(product);
		return new ResponseEntity<ProductDTO>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "product/stock/{productNumber}", method = RequestMethod.POST)
	public ResponseEntity<?> setStock(@PathVariable(value ="productNumber") String productNumber,
			@RequestBody StockDTO stock) {
		productService.setStock(stock.getQuantity(), stock.getLocationCode(), productNumber);
		return new ResponseEntity<ProductDTO>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "product", method = RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO product) {
		productService.addProduct(product.getProductNumber(), product.getName(),
				product.getDescription(), product.getPrice());
		return new ResponseEntity<ProductDTO>(HttpStatus.OK);
	}
}
