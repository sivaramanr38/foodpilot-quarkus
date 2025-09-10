package org.foodpilot.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.foodpilot.model.Restaurant;

@ApplicationScoped
public class RestaurantRepository implements PanacheRepository<Restaurant> {
}
