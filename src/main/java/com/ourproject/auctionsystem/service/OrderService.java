package com.ourproject.auctionsystem.service;

import java.util.ArrayList;
import java.util.List;
import com.ourproject.auctionsystem.pojo.Order;

public class OrderService implements IOrderService {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void createOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void updateOrderStatus(Order order) {
        int index = orders.indexOf(getOrderById(order.getOrderID()));
        if (index != -1) {
            orders.set(index, order);
        }
    }

    @Override
    public Order getOrderById(int orderId) {
        return orders.stream()
                .filter(order -> order.getOrderID() == orderId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public void deleteOrder(int orderId) {
        orders.removeIf(order -> order.getOrderID() == orderId);
    }
}
