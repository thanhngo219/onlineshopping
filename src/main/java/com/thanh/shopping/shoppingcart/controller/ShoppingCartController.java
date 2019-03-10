package com.thanh.shopping.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thanh.shopping.converter.DtoConverter;
import com.thanh.shopping.order.dto.OrderDTO;
import com.thanh.shopping.shoppingcart.domain.ShoppingCart;
import com.thanh.shopping.shoppingcart.dto.CartLineDTO;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;
import com.thanh.shopping.shoppingcart.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping(value = "shoppingCart/{cartId}", method = RequestMethod.GET)
	public ResponseEntity<?> getCartByPath(@PathVariable(value = "cartId") String cartId) {
		ShoppingCart sc = shoppingCartService.getCart(cartId);
		ShoppingCartDTO result = DtoConverter.shoppingCartToDTO(sc);
		return new ResponseEntity<ShoppingCartDTO>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "shoppingCart/{cartId}", method = RequestMethod.POST)
	public ResponseEntity<?> addToCart(@PathVariable(value = "cartId") String cartId,
			@RequestBody CartLineDTO cartLineDTO) {
		shoppingCartService.addToCart(cartId, cartLineDTO.getProductNumber(), cartLineDTO.getQuantity());
		return new ResponseEntity<ShoppingCartDTO>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "shoppingCart/checkOut/{cartId}", method = RequestMethod.POST)
	public ResponseEntity<?> checkOutCart(@PathVariable(value = "cartId") String cartId) {
		shoppingCartService.checkOut(cartId);
		return new ResponseEntity<OrderDTO>(HttpStatus.OK);
	}
}