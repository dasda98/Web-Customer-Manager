package com.wcm.webcustomermanager.dao;

import com.wcm.webcustomermanager.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    Customer getCustomer(int id);

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void deleteCustomer(int id);
}
