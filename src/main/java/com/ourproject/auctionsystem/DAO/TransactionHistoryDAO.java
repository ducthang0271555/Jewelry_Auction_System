package com.ourproject.auctionsystem.DAO;

import com.ourproject.auctionsystem.pojo.TransactionHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryDAO {
    private Connection connection;

    public TransactionHistoryDAO(Connection connection) {
        this.connection = connection;
    }

    // Get a single TransactionHistory by its ID
    public TransactionHistory getTransactionHistoryById(int id) {
        TransactionHistory transactionHistory = null;
        String sql = "SELECT * FROM transaction_history WHERE transactionId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                transactionHistory = new TransactionHistory();
                transactionHistory.setTransactionID(resultSet.getInt("transactionID"));
                transactionHistory.setUserID(resultSet.getInt("userID"));
                transactionHistory.setItemID(resultSet.getInt("itemID"));
                transactionHistory.setTransactionDate(resultSet.getDate("transactionDate"));
                transactionHistory.setAmount(resultSet.getDouble("amount"));
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
        return transactionHistory;
    }

    // Update TransactionHistory information
    public boolean updateTransactionHistory(TransactionHistory transactionHistory) {
        String sql = "UPDATE transaction_history SET userId = ?, itemId = ?, transactionDate = ?, amount = ? WHERE transactionId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, transactionHistory.getUserID());
            statement.setInt(2, transactionHistory.getItemID());
            statement.setDate(3, new java.sql.Date(transactionHistory.getTransactionDate().getTime()));
            statement.setDouble(4, transactionHistory.getAmount());
            statement.setInt(5, transactionHistory.getTransactionID());
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

    // Insert a new TransactionHistory
    public boolean insertTransactionHistory(TransactionHistory transactionHistory) {
        String sql = "INSERT INTO transaction_history (userId, itemId, transactionDate, amount) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, transactionHistory.getUserID());
            statement.setInt(2, transactionHistory.getItemID());
            statement.setDate(3, new java.sql.Date(transactionHistory.getTransactionDate().getTime()));
            statement.setDouble(4, transactionHistory.getAmount());
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

    // Delete a TransactionHistory
    public boolean deleteTransactionHistory(int id) {
        String sql = "DELETE FROM transaction_history WHERE transactionId = ?";
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

    // Get all TransactionHistory
    public List getTransactionHistoryList() { // Không sử dụng generic
        List transactionHistoryList = new ArrayList(); // Không sử dụng generic
        String sql = "SELECT * FROM transaction_history";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TransactionHistory transactionHistory = new TransactionHistory();
                transactionHistory.setTransactionID(resultSet.getInt("transactionId"));
                transactionHistory.setUserID(resultSet.getInt("userId"));
                transactionHistory.setItemID(resultSet.getInt("itemId"));
                transactionHistory.setTransactionDate(resultSet.getDate("transactionDate"));
                transactionHistory.setAmount(resultSet.getDouble("amount"));
                transactionHistoryList.add(transactionHistory);
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
        return transactionHistoryList;
    }
}
