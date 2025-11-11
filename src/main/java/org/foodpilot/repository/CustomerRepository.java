package org.foodpilot.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.foodpilot.model.Customer;
import org.foodpilot.model.Restaurant;

import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    @PersistenceContext
    EntityManager entityManager;

    public Customer getCustomerByEmail(String email) {
        String jpql = "SELECT c FROM Customer c WHERE c.email = :email";
        Customer customer = entityManager
                .createQuery(jpql, Customer.class)
                .setParameter("email",email)
                .getSingleResult();
        return customer;
    }
}
