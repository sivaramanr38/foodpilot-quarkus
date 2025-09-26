package org.foodpilot.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.foodpilot.model.Customer;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

}
