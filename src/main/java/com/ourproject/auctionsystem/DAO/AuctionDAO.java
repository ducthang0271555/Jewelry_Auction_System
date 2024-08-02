package com.ourproject.auctionsystem.DAO;

import com.ourproject.auctionsystem.pojo.Auction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionDAO {
    private Connection connection;

    public AuctionDAO(Connection connection) {
        this.connection = connection;
    }

    // Get a single Auction by its ID
    public Auction getAuctionById(int id) {
        Auction auction = null;
        String sql = "SELECT * FROM auction WHERE auctionId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                auction = new Auction();
                auction.setAuctionID(resultSet.getInt("auctionId"));
                auction.setStartTime(resultSet.getDate("startTime"));
                auction.setEndTime(resultSet.getDate("endTime"));
                auction.setStatus(resultSet.getString("status"));
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
        return auction;
    }

    // Update Auction information
    public boolean updateAuction(Auction auction) {
        String sql = "UPDATE auction SET startTime = ?, endTime = ?, status = ? WHERE auctionId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(auction.getStartTime().getTime()));
            statement.setDate(2, new java.sql.Date(auction.getEndTime().getTime()));
            statement.setString(3, auction.getStatus());
            statement.setInt(4, auction.getAuctionID());
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

    // Insert a new Auction
    public boolean insertAuction(Auction auction) {
        String sql = "INSERT INTO auction (startTime, endTime, status) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(auction.getStartTime().getTime()));
            statement.setDate(2, new java.sql.Date(auction.getEndTime().getTime()));
            statement.setString(3, auction.getStatus());
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

    // Delete an Auction
    public boolean deleteAuction(int id) {
        String sql = "DELETE FROM auction WHERE auctionId = ?";
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

//
