package com.wcm.webcustomermanager.dao.product;

import com.wcm.webcustomermanager.entity.Customer;
import com.wcm.webcustomermanager.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product getProduct(int id) {

        Session session = sessionFactory.getCurrentSession();

        Product product = session.get(Product.class, id);

        return product;
    }

    @Override
    public List<Product> getProducts() {

        Session session = sessionFactory.getCurrentSession();

        Query<Product> productQuery = session.createQuery("from Product", Product.class);

        List<Product> productList = productQuery.getResultList();

        return productList;
    }

    @Override
    public void saveProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(product);

    }

    @Override
    public void deleteProduct(int id) {

        Session session = sessionFactory.getCurrentSession();

        Query productQuert = session.createQuery("delete from Product where id=:productId");
        productQuert.setParameter("productId", id);

        productQuert.executeUpdate();
    }

    @Override
    public List<Product> searchProducts(String searchName) {

        Session session = sessionFactory.getCurrentSession();

        Query query = null;

        if (searchName != null && searchName.trim().length() > 0) {
            query = session.createQuery(
                    "from Product where " +
                            "lower(name) like :theName",
                    Product.class);
            query.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        } else {
            query = session.createQuery("from Product", Product.class);
        }

        List<Product> productList = query.getResultList();

        return productList;
    }
}
