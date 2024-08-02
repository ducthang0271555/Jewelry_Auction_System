package com.ourproject.auctionsystem.DAO;

import com.ourproject.auctionsystem.pojo.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    // Get a single Payment by its ID
    public Payment getPaymentById(int id) {
        Payment payment = null;
        String sql = "SELECT * FROM payments WHERE paymentId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                payment = new Payment();
                payment.setPaymentID(resultSet.getInt("paymentId"));
                payment.setOrderID(resultSet.getInt("orderId"));
                payment.setPaymentAmount(resultSet.getDouble("paymentAmount"));
                payment.setPaymentDate(resultSet.getDate("paymentDate"));
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
        return payment;
    }

    // Update Payment information
    public boolean updatePayment(Payment payment) {
        String sql = "UPDATE payments SET orderId = ?, paymentAmount = ?, paymentDate = ? WHERE paymentId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, payment.getOrderID());
            statement.setDouble(2, payment.getPaymentAmount());
            statement.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
            statement.setInt(4, payment.getPaymentID());
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

    // Insert a new Payment
    public boolean insertPayment(Payment payment) {
        String sql = "INSERT INTO payments (orderId, paymentAmount, paymentDate) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, payment.getOrderID());
            statement.setDouble(2, payment.getPaymentAmount());
            statement.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
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

    // Delete a Payment
    public boolean deletePayment(int id) {
        String sql = "DELETE FROM payments WHERE paymentId = ?";
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

    // Get all Payments
    public List getPaymentList() { // Không sử dụng generic
        List paymentList = new ArrayList(); // Không sử dụng generic
        String sql = "SELECT * FROM payments";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setPaymentID(resultSet.getInt("paymentId"));
                payment.setOrderID(resultSet.getInt("orderId"));
                payment.setPaymentAmount(resultSet.getDouble("paymentAmount"));
                payment.setPaymentDate(resultSet.getDate("paymentDate"));
                paymentList.add(payment);
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
        return paymentList;
    }
}