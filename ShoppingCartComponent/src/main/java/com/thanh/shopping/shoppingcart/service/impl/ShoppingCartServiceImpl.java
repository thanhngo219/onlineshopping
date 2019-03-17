package com.thanh.shopping.shoppingcart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thanh.shopping.mapper.DtoMapper;
import com.thanh.shopping.shoppingcart.domain.ShoppingCart;
import com.thanh.shopping.shoppingcart.dto.ProductDTO;
import com.thanh.shopping.shoppingcart.dto.ShoppingCartDTO;
import com.thanh.shopping.shoppingcart.repository.ShoppingCartRepository;
import com.thanh.shopping.shoppingcart.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
//	@Autowired
//	private ProductService productService;
//	
//	@Autowired
//	private OrderService orderService;
//	
	@Autowired
	@Qualifier("shoppingCartMapper")
	private DtoMapper<ShoppingCart, ShoppingCartDTO> dtoMapper;
	
	@Override
	public void addToCart(String cartId, ProductDTO productDTO, Long quantity) {
//		Product product = productService.getProduct(productDTO.getProductNumber());
//		ShoppingCart cart = getShoppingCart(cartId);
//		if (cart != null && product != null) {
//			cart.addToCart(product.getProductNumber(), product.getName(), product.getPrice(), quantity);
//		}
//		else if (product != null) {
//			cart = new ShoppingCart();
//			cart.setCartId(cartId);
//			cart.addToCart(product.getProductNumber(), product.getName(), product.getPrice(), quantity);
//		}
//		shoppingCartRepository.save(cart);
	}

	@Override
	public ShoppingCartDTO getShoppingCartDTO(String cartId) {
		Optional<ShoppingCart> optCart = shoppingCartRepository.findById(cartId);
		if (optCart.isPresent()) {
			return dtoMapper.toDTO(optCart.get());
		}
		return null;
	}

	@Override
	public void checkOut(String cartId) {
		ShoppingCart shoppingCart = getShoppingCart(cartId);
		if (shoppingCart != null) {
//			orderService.createOrder(shoppingCart);
		}
	}

	@Override
	public ShoppingCart getShoppingCart(String cartId) {
		Optional<ShoppingCart> optCart = shoppingCartRepository.findById(cartId);
		if (optCart.isPresent()) {
			return optCart.get();
		}
		return null;
	}

	@Override
	public void updateProductsInCarts(String productNumber, String productName, Double price) {
		
	}
}
