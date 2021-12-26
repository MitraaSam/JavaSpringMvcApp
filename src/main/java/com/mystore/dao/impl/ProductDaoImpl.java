package com.mystore.dao.impl;

import com.mystore.dao.ProductDao;
import com.mystore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    private final SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProduct(Product product) {

        Session session =sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public void editProduct(Product product) {

        Session session =sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public Product getProductById(int id) {
        Session session =sessionFactory.getCurrentSession();
        Product product=session.get(Product.class,id);
        session.flush();
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        Session session =sessionFactory.getCurrentSession();
        Query query =session.createQuery("from Product ");
        List<Product> products =query.list();
        session.flush();
        return products;
    }

    @Override
    public void deleteProduct(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();

    }
}
