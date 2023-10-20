package de.ait.service;

import de.ait.dto.OrderDto;
import de.ait.models.Order;
import de.ait.repositories.OrderRepository;

import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> searchByUserID(String userId) {
        List<Order> list = orderRepository.findAll().stream()
                .filter(o -> o.getOrderId().equals(userId))
                .toList();
        return list;
    }

    @Override
    public void printAllOrders() {
        orderRepository.findAll().forEach(order -> System.out.println(order));
    }


    @Override
    public void add(OrderDto orderDto) {
        Order order = new Order(UUID.randomUUID().toString(),
                orderDto.getGroomingId(),
                orderDto.getUserId(),
                orderDto.getDateTime());
        orderRepository.save(order);
    }
}
