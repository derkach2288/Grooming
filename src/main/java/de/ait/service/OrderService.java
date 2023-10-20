package de.ait.service;

import de.ait.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<String> getOrders();
    List<String> searchByUserID(String orderID);
    List<String> searchByGroomingId(String groomingId);
    void add(OrderDto orderDto);

}
