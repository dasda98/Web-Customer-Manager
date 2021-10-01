package com.wcm.webcustomermanager.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "customer_product",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "customer_id")
//    )
    @ManyToMany(mappedBy = "productList")
    private Set<Customer> customerList;

    public Product() {}

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(Set<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addCustomer(Customer customer) {
        if (customerList == null) {
            customerList = new HashSet<Customer>();
        }
        customerList.add(customer);
        customer.getProductList().add(this);
    }

    public void removeCustomer(Customer customer) {
        customerList.remove(customer);
        customer.getProductList().remove(this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
