package com.reliancejio.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reliancejio.order.model.OrderDetails;



public interface Orderservice {
	
	List<OrderDetails> getOrders();

	OrderDetails getOrder(Integer id);
	
	OrderDetails createOrder(OrderDetails order);
	
	OrderDetails updateOrder(Integer orderId, OrderDetails order);
	
	void deleteOrder(Integer orderId);

}
