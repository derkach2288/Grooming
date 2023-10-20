package de.ait.repositories;

import de.ait.dto.OrderDto;
import de.ait.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepositoryListImpl implements OrderRepository{

    OrderDto orderDto = new OrderDto("groomingId1", "userId1", "22-11-88, 10-00");
    private List<Order> orderList = new ArrayList<>(List.of(
//            new Order(UUID.randomUUID().toString(), new OrderDto("groomingId1", "userId1", "22-11-88, 10-00"))
            new Order(UUID.randomUUID().toString(), orderDto.getGroomingId(), orderDto.getUserId(), orderDto.getDateTime())
    ));

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void save(Order order) {

    }
}
