package de.ait.repositories;

import de.ait.models.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();

    void save(Order order);
}
