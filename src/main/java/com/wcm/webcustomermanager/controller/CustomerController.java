package com.wcm.webcustomermanager.controller;

import com.wcm.webcustomermanager.entity.Customer;
import com.wcm.webcustomermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String customerList(Model model) {

        List<Customer> customerList = customerService.getCustomers();

        model.addAttribute("customerList", customerList);

        return "customer-list";
    }
}
