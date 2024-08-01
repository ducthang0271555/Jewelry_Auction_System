package com.ourproject.auctionsystem.service;

import java.util.List;
import com.ourproject.auctionsystem.pojo.Customer;

public interface ICustomerService {
    void registerForAuction(Customer customer);
    void placeBid(Customer customer);
    void makePayment(Customer customer);
    void viewAuctionResult(Customer customer);
    Customer getCustomerById(int customerId);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
}
