package com.ourproject.auctionsystem.DAO;

import com.ourproject.auctionsystem.pojo.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO {
    private Connection connection;

    public SellerDAO(Connection connection) {
        this.connection = connection;
    }

    // Get a single Seller by its ID
    public Seller getSellerById(int id) {
        Seller seller = null;
        String sql = "SELECT * FROM sellers WHERE sellerId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                seller = new Seller();
                seller.setSellerID(resultSet.getInt("sellerId"));
                seller.setName(resultSet.getString("name"));
                seller.setEmail(resultSet.getString("email"));
                seller.setPhoneNumber(resultSet.getString("phoneNumber"));
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
        return seller;
    }

    // Update Seller information
    public boolean updateSeller(Seller seller) {
        String sql = "UPDATE sellers SET name = ?, email = ?, phoneNumber = ?, storeName = ? WHERE sellerId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, seller.getName());
            statement.setString(2, seller.getEmail());
            statement.setString(3, seller.getPhoneNumber());
            statement.setInt(5, seller.getSellerID());
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

    // Insert a new Seller
    public boolean insertSeller(Seller seller) {
        String sql = "INSERT INTO sellers (name, email, phoneNumber, storeName) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, seller.getName());
            statement.setString(2, seller.getEmail());
            statement.setString(3, seller.getPhoneNumber());
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

    // Delete a Seller
    public boolean deleteSeller(int id) {
        String sql = "DELETE FROM sellers WHERE sellerId = ?";
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

    // Get all Sellers
    public List getSellerList() { // Không sử dụng generic
        List sellerList = new ArrayList(); // Không sử dụng generic
        String sql = "SELECT * FROM sellers";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Seller seller = new Seller();
                seller.setSellerID(resultSet.getInt("sellerId"));
                seller.setName(resultSet.getString("name"));
                seller.setEmail(resultSet.getString("email"));
                seller.setPhoneNumber(resultSet.getString("phoneNumber"));
                sellerList.add(seller);
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
        return sellerList;
    }
}