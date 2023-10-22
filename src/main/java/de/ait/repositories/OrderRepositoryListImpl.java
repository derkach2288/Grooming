package de.ait.repositories;

import de.ait.dto.OrderDto;
import de.ait.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepositoryListImpl implements OrderRepository{

    private List<Order> orderList = new ArrayList<>(List.of(
            new Order("orderId1", "GroomingId1", "UserId1", "22-11-2023, 10-00"),
            new Order("orderId2", "GroomingId2", "UserId2", "22-10-2023, 11-00"),
            new Order("orderId3", "GroomingId3", "UserId3", "22-12-2023, 12-00")
    ));

    @Override
    public List<Order> findAll() {
        return orderList;
    }

    @Override
    public void save(Order order) {
        orderList.add(order);
    }
}
