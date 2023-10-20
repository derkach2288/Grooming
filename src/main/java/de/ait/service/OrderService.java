package de.ait.service;

import de.ait.dto.OrderDto;
import de.ait.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    List<Order> searchByUserID(String userID);
    void add(OrderDto orderDto);

}
