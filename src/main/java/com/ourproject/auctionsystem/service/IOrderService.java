package com.ourproject.auctionsystem.service;
import java.util.List;
import com.ourproject.auctionsystem.pojo.Order;

public interface IOrderService {
    void createOrder(Order order);
    void updateOrderStatus(Order order);
    Order getOrderById(int orderId);
    List<Order> getAllOrders();
    void deleteOrder(int orderId);
}