package com.example.order_service.service;

import com.example.order_service.client.UserClient;
import com.example.order_service.dto.User;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final UserClient userClient;

    public OrderService(OrderRepository repository,
                        UserClient userClient) {
        this.repository = repository;
        this.userClient = userClient;
    }

    public Order createOrder(Order order) {

        User user = userClient.getUserById(order.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return repository.save(order);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrderById(Long id) {
        return repository.findById(id).orElse(null);
    }
}