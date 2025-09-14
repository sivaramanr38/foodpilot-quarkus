package org.foodpilot.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.foodpilot.model.Restaurant;
import java.time.LocalTime;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RestaurantRepository implements PanacheRepository<Restaurant> {

    @PersistenceContext
    EntityManager entityManager;

    // This uses JPQL
    public List<Restaurant> getRestaurantsByCuisine(String cuisineType) {
        String jpql = "SELECT r FROM Restaurant r WHERE r.cuisineType = :cuisineType";
        List<Restaurant> restaurants = entityManager
                .createQuery(jpql, Restaurant.class)
                .setParameter("cuisineType",cuisineType)
                .getResultList();
        return restaurants;
    }

    // This uses Panache version of fetching
    public List<Restaurant> getOpenRestaurants(int page, int size) {
        LocalTime now = LocalTime.now(); // current time

        return findAll()
                .page(Page.of(page, size))
                .list()
                .stream()
                .filter(r -> {
                    LocalTime open = r.openTime;
                    LocalTime close = r.closeTime;
                    return !now.isBefore(open) && !now.isAfter(close);
                })
                .collect(Collectors.toList());
    }
}
