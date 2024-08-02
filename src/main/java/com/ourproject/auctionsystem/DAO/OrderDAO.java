package com.ourproject.auctionsystem.DAO;

import com.ourproject.auctionsystem.pojo.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    // Get a single Order by its ID
    public Order getOrderById(int id) {
        Order order = null;
        String sql = "SELECT * FROM orders WHERE orderId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order = new Order();
                order.setOrderID(resultSet.getInt("orderId"));
                order.setAuctionID(resultSet.getInt("auctionId"));
                order.setCustomerID(resultSet.getInt("customerId"));
                order.setOrderStatus(resultSet.getString("orderStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return order;
    }

    // Update Order information
    public boolean updateOrder(Order order) {
        String sql = "UPDATE orders SET auctionId = ?, customerId = ?, orderStatus = ? WHERE orderId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getAuctionID());
            statement.setInt(2, order.getCustomerID());
            statement.setString(3, order.getOrderStatus());
            statement.setInt(4, order.getOrderID());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Insert a new Order
    public boolean insertOrder(Order order) {
        String sql = "INSERT INTO orders (auctionId, customerId, orderStatus) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getAuctionID());
            statement.setInt(2, order.getCustomerID());
            statement.setString(3, order.getOrderStatus());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Delete an Order
    public boolean deleteOrder(int id) {
        String sql = "DELETE FROM orders WHERE orderId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Get all Orders
    public List getOrderList() { // Không sử dụng generic
        List orderList = new ArrayList(); // Không sử dụng generic
        String sql = "SELECT * FROM orders";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt("orderId"));
                order.setAuctionID(resultSet.getInt("auctionId"));
                order.setCustomerID(resultSet.getInt("customerId"));
                order.setOrderStatus(resultSet.getString("orderStatus"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return orderList;
    }
}

