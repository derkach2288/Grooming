package de.ait.service;

import de.ait.dto.OrderDto;
import de.ait.models.Order;
import de.ait.repositories.OrderRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderServiceImpl(new OrderRepositoryListImpl());
    }

    @Test
    void findAll() {
        List<Order> actual = orderService.findAll();
        List<Order> expected = new ArrayList<>(List.of(
                new Order("orderId1", "GroomingId1", "UserId1", "22-11-2023, 10-00"),
                new Order("orderId2", "GroomingId2", "UserId2", "22-10-2023, 11-00"),
                new Order("orderId3", "GroomingId3", "UserId3", "22-12-2023, 12-00")
        ));
        assertEquals(expected, actual);
    }

    @Test
    void searchByUserID() {
        List<Order> actual = orderService.searchByUserID("UserId1");
//        List<Order> actual = orderService.findAll().stream().filter(order -> order.getOrderId().equals("orderId1")).toList();
        List<Order> expected = new ArrayList<>(List.of(
                new Order("orderId1", "GroomingId1", "UserId1", "22-11-2023, 10-00")
        ));
        assertEquals(expected, actual);
    }

    @Test
    void printAllOrders() {
        orderService.printAllOrders();
    }

    @Test
    void add() {
        OrderDto orderDto = new OrderDto("groomingId", "userId", "22-11-2023, 10-00");
        orderService.add(orderDto);
        List<Order> actual = orderService.findAll();
        assertEquals(4, actual.size());
    }
}