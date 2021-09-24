package com.wcm.webcustomermanager.service;

import com.wcm.webcustomermanager.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(int id);

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void deleteCustomer(int id);
}
