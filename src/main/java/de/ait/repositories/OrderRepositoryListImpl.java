package de.ait.repositories;

import de.ait.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepositoryListImpl implements OrderRepository{

    private List<Order> orderList = new ArrayList<>(List.of(
//            new Order(UUID.randomUUID().toString(), "groomingId1", "userId2",)
    ));

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void save(Order order) {

    }
}
