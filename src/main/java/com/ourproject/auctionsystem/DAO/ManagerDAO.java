package com.ourproject.auctionsystem.DAO;

import com.ourproject.auctionsystem.pojo.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO {
    private Connection connection;

    public ManagerDAO(Connection connection) {
        this.connection = connection;
    }

    // Get a single Manager by its ID
    public Manager getManagerById(int id) {
        Manager manager = null;
        String sql = "SELECT * FROM managers WHERE managerId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                manager = new Manager();
                manager.setManagerID(resultSet.getInt("managerId"));
                manager.setName(resultSet.getString("name"));
                manager.setEmail(resultSet.getString("email"));
                manager.setPhoneNumber(resultSet.getString("phoneNumber"));
                manager.setDepartment(resultSet.getString("department"));
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
        return manager;
    }

    // Update Manager information
    public boolean updateManager(Manager manager) {
        String sql = "UPDATE managers SET name = ?, email = ?, phoneNumber = ?, department = ? WHERE managerId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, manager.getName());
            statement.setString(2, manager.getEmail());
            statement.setString(3, manager.getPhoneNumber());
            statement.setString(4, manager.getDepartment());
            statement.setInt(5, manager.getManagerID());
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

    // Insert a new Manager
    public boolean insertManager(Manager manager) {
        String sql = "INSERT INTO managers (name, email, phoneNumber, department) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, manager.getName());
            statement.setString(2, manager.getEmail());
            statement.setString(3, manager.getPhoneNumber());
            statement.setString(4, manager.getDepartment());
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

    // Delete a Manager
    public boolean deleteManager(int id) {
        String sql = "DELETE FROM managers WHERE managerId = ?";
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

    // Get all Managers
    public List getManagerList() { // Không sử dụng generic
        List managerList = new ArrayList(); // Không sử dụng generic
        String sql = "SELECT * FROM managers";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Manager manager = new Manager();
                manager.setManagerID(resultSet.getInt("managerId"));
                manager.setName(resultSet.getString("name"));
                manager.setEmail(resultSet.getString("email"));
                manager.setPhoneNumber(resultSet.getString("phoneNumber"));
                manager.setDepartment(resultSet.getString("department"));
                managerList.add(manager);
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
        return managerList;
    }
}
