package com.reliancejio.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reliancejio.order.repository.OrderRepository;
import com.reliancejio.order.model.OrderDetails;

import com.reliancejio.order.exception.OrderNotFoundException;


@Service

public class OrderServiceimpl implements Orderservice {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<OrderDetails> getOrders() {
		List<OrderDetails> orders = orderRepository.findAll();
		return orders;	
	}

	@Override
	public OrderDetails getOrder(Integer id) {
		Optional<OrderDetails> order = orderRepository.findById(id);
		if(!order.isPresent()) {
			System.out.println("orderitem does not exist in the database!");
			throw new OrderNotFoundException("order does not exist in the database!");
		} else {
			return order.get();
		}
	}

	
	@Override
	public OrderDetails createOrder(OrderDetails order) {
		OrderDetails dbOrder = orderRepository.save(order);
		return dbOrder;
	}

	@Override
	public OrderDetails updateOrder(Integer id, OrderDetails order) {
		Optional<OrderDetails> dbOrder = orderRepository.findById(id);
		if(!dbOrder.isPresent()) {
			System.out.println("order does not exist in the database!");
			throw new OrderNotFoundException("order does not exist in the database!");
		} else {
			OrderDetails toBeUpdated = dbOrder.get();
			toBeUpdated.setItemName(order.getItemName());
			toBeUpdated.setDate(order.getDate());
			OrderDetails updatedOrder = orderRepository.save(toBeUpdated);
			return updatedOrder;
		}
	}

	

	@Override
	public void deleteOrder(Integer id) {
		
		Optional<OrderDetails> dbOrder = orderRepository.findById(id);
		if (dbOrder.isPresent()) {
			orderRepository.delete(dbOrder.get());	
			System.out.println("order has been deleted: " + id);
		} else {
			System.out.println("order Does Not Found!");
			throw new OrderNotFoundException("order does not exist in the database!");
		}	
	}



}
