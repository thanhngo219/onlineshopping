package com.thanh.shopping.converter;

import com.thanh.shopping.domain.order.Order;
import com.thanh.shopping.domain.order.OrderLine;
import com.thanh.shopping.domain.product.Product;
import com.thanh.shopping.domain.shoppingcart.ShoppingCart;
import com.thanh.shopping.domain.shoppingcart.ShoppingCartLine;
import com.thanh.shopping.dto.CartLineDTO;
import com.thanh.shopping.dto.OrderDTO;
import com.thanh.shopping.dto.OrderLineDTO;
import com.thanh.shopping.dto.ProductDTO;
import com.thanh.shopping.dto.ShoppingCartDTO;
import com.thanh.shopping.dto.StockDTO;

public class DtoConverter {
	public static ProductDTO productToDTO(Product p) {
		ProductDTO result = new ProductDTO();
		if (p == null) {
			return null;
		}
		result.setProductNumber(p.getProductNumber());
		result.setName(p.getName());
		result.setDescription(p.getDescription());
		result.setPrice(p.getPrice());
		if (p.getStock() != null) {
			result.setStock(new StockDTO(p.getStock().getLocationCode(), p.getStock().getQuantity()));
		}
		return result;
	}
	
	public static ShoppingCartDTO shoppingCartToDTO(ShoppingCart sc) {
		ShoppingCartDTO result = new ShoppingCartDTO(sc.getCartId());
		for(ShoppingCartLine scl : sc.getCartLines()) {
			CartLineDTO cartLineDto = cartLineToDTO(scl);
			result.addToCartLines(cartLineDto);
		}
		return result;
	}

	public static CartLineDTO cartLineToDTO(ShoppingCartLine scl) {
		CartLineDTO cartLineDto = new CartLineDTO(scl.getProduct().getProductNumber(), scl.getQuantity());
		return cartLineDto;
	}
	
	public static OrderDTO orderToDTO(Order order) {
		OrderDTO result = new OrderDTO(order.getOrderId(), order.getOrderDate(), order.getOrderStatus());
		for(OrderLine orderLine : order.getOrderLines()) {
			result.addToOrderLines(orderLineToDTO(orderLine));
		}
		return result;
	}
	
	public static OrderLineDTO orderLineToDTO(OrderLine orderLine) {
		return new OrderLineDTO(orderLine.getProduct().getProductNumber(), orderLine.getQuantity());
	}
}
