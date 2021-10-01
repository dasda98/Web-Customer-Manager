package com.wcm.webcustomermanager.controller;

import com.wcm.webcustomermanager.entity.Customer;
import com.wcm.webcustomermanager.entity.Product;
import com.wcm.webcustomermanager.service.customer.CustomerService;
import com.wcm.webcustomermanager.service.product.ProductService;
import com.wcm.webcustomermanager.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/customer")
public class CustomerController{

    private final CustomerService customerService;

    private final ProductService productService;

    private final CustomerValidator customerValidator;

    @Autowired
    public CustomerController(CustomerService customerService,
                              ProductService productService,
                              CustomerValidator customerValidator
    ) {
        this.customerService = customerService;
        this.productService = productService;
        this.customerValidator = customerValidator;
    }

    @GetMapping("/list")
    public String customerList(Model model) {

        List<Customer> customerList = customerService.getCustomers();

        model.addAttribute("customerList", customerList);

        return "customers-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        List<Product> productList = productService.getProducts();

        model.addAttribute("product", productList);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer,
                               BindingResult bindingResult, Model model) {

        customerValidator.validate(customer, bindingResult);

        if (bindingResult.hasErrors()) {
            List<Product> productList = productService.getProducts();
            model.addAttribute("product", productList);

            return "customer-form";
        }

        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {

        Customer customer = customerService.getCustomer(id);

        List<Product> productList = productService.getProducts();

        model.addAttribute("product", productList);
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id) {

        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

    @GetMapping("/showProducts")
    public String showProducts(@RequestParam("customerId") int id, Model model) {

        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer", customer);

        return "customer-product-list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("searchName") String searchName, Model model) {

        List<Customer> customerList = customerService.searchCustomers(searchName);

        model.addAttribute("customerList", customerList);

        return "customers-list";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Product.class, "productList", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Pattern pattern = Pattern.compile("(?<=id=)(\\d+)*(?=,)");
                Matcher matcher = pattern.matcher(text);

                Product product = null;

                if (matcher.find()) {
                    product = productService.getProduct(Integer.parseInt(matcher.group(0)));
                }

                setValue(product);
            }
        });
    }
}
