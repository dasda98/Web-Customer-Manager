package com.wcm.webcustomermanager.dao.customer;

import com.wcm.webcustomermanager.entity.Customer;
import com.wcm.webcustomermanager.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer getCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, id);

        return customer;
    }

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> customerQuery = session.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customerList = customerQuery.getResultList();

        return customerList;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        Query customerQuery = session.createQuery("delete from Customer where id=:customerId");
        customerQuery.setParameter("customerId", id);

        customerQuery.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {

        Session session = sessionFactory.getCurrentSession();

        Query query = null;

        if (searchName != null && searchName.trim().length() > 0) {
            query = session.createQuery(
                    "from Customer where " +
                            "lower(firstName) like :theName or " +
                            "lower(lastName) like :theName",
                    Customer.class);
            query.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        } else {
            query = session.createQuery("from Customer ", Customer.class);
        }

        List<Customer> customerList = query.getResultList();

        return customerList;
    }
}
