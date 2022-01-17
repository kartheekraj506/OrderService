package com.reliancejio.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.reliancejio.order.model.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

}
