package com.ourproject.auctionsystem.DAO;

import com.ourproject.auctionsystem.Models.Jewelry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JewelryDAO {
    private Connection connection;

    public JewelryDAO(Connection connection) {
        this.connection = connection;
    }

    // Get a single Jewelry by its ID
    public Jewelry getJewelryById(int id) {
        Jewelry jewelry = null;
        String sql = "SELECT * FROM jewelry WHERE jewelryId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                jewelry = new Jewelry();
                jewelry.setJewelryId(resultSet.getInt("jewelryId"));
                jewelry.setName(resultSet.getString("name"));
                jewelry.setDescription(resultSet.getString("description"));
                jewelry.setInitialPrice(resultSet.getDouble("initialPrice"));
                jewelry.setFinalPrice(resultSet.getDouble("finalPrice"));
                jewelry.setStatus(resultSet.getString("status"));
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
        return jewelry;
    }

    // Update Jewelry information
    public boolean updateJewelry(Jewelry jewelry) {
        String sql = "UPDATE jewelry SET name = ?, description = ?, initialPrice = ?, finalPrice = ?, status = ? WHERE jewelryId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, jewelry.getName());
            statement.setString(2, jewelry.getDescription());
            statement.setDouble(3, jewelry.getInitialPrice());
            statement.setDouble(4, jewelry.getFinalPrice());
            statement.setString(5, jewelry.getStatus());
            statement.setInt(6, jewelry.getJewelryId());
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

    // Insert a new Jewelry
    public boolean insertJewelry(Jewelry jewelry) {
        String sql = "INSERT INTO jewelry (name, description, initialPrice, finalPrice, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, jewelry.getName());
            statement.setString(2, jewelry.getDescription());
            statement.setDouble(3, jewelry.getInitialPrice());
            statement.setDouble(4, jewelry.getFinalPrice());
            statement.setString(5, jewelry.getStatus());
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

    // Delete a Jewelry
    public boolean deleteJewelry(int id) {
        String sql = "DELETE FROM jewelry WHERE jewelryId = ?";
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
}
