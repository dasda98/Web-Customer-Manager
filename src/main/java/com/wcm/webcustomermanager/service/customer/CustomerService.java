package com.wcm.webcustomermanager.service.customer;

import com.wcm.webcustomermanager.entity.Customer;
import com.wcm.webcustomermanager.entity.Product;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(int id);

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String searchName);
}
