package com.ourproject.auctionsystem.service;

import com.ourproject.auctionsystem.pojo.Customer;
import com.ourproject.auctionsystem.service.ICustomerService;
import jakarta.persistence.*;
import java.util.List;

public class CustomerService implements ICustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void registerForAuction(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void placeBid(Customer customer) {
        Customer existingCustomer = entityManager.find(Customer.class, customer.getCustomerID());
        if (existingCustomer != null) {
            // Logic to place bid (implementation details would depend on the bid process)
            entityManager.merge(existingCustomer);
        }
    }

    @Override
    public void makePayment(Customer customer) {
        Customer existingCustomer = entityManager.find(Customer.class, customer.getCustomerID());
        if (existingCustomer != null) {
            // Logic to make payment (implementation details would depend on the payment process)
            entityManager.merge(existingCustomer);
        }
    }

    @Override
    public void viewAuctionResult(Customer customer) {
        Customer existingCustomer = entityManager.find(Customer.class, customer.getCustomerID());
        if (existingCustomer != null) {
            // Logic to view auction result (implementation details would depend on how results are stored)
            entityManager.merge(existingCustomer);
        }
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return entityManager.find(Customer.class, customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}
