package com.thanh.shopping.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.thanh.shopping.product.dto.OrderedProductDTO;
import com.thanh.shopping.product.service.ProductService;


@Component
public class OrderedProductListener {
	
	@Autowired
	private ProductService productService;

    @JmsListener(destination = "Ordered Products")
    public void receiveMessage(final List<OrderedProductDTO> orderedProductDtos) {
    	System.out.println("JMS receiver received message:" + orderedProductDtos);
    	productService.reduceProductInStock(orderedProductDtos);
    }
    
}
