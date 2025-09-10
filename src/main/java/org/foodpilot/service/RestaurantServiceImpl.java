package org.foodpilot.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.foodpilot.model.Restaurant;
import org.foodpilot.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RestaurantServiceImpl implements RestaurantService{

    @Inject
    RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.listAll();
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findByIdOptional(id);
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.persist(restaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public void updateRestaurant(Long id, Restaurant updatedRestaurant) {
        Restaurant existing = restaurantRepository.findById(id);
        if (existing != null) {
            existing.name = updatedRestaurant.name;
            existing.cuisineType = updatedRestaurant.cuisineType;
            existing.location = updatedRestaurant.location;
            existing.ratings = updatedRestaurant.ratings;
            existing.ratingsCount = updatedRestaurant.ratingsCount;
            existing.promotions = updatedRestaurant.promotions;
            existing.freeDelivery = updatedRestaurant.freeDelivery;
            existing.dineIn = updatedRestaurant.dineIn;
            existing.takeaway = updatedRestaurant.takeaway;
            existing.openTime = updatedRestaurant.openTime;
            existing.closeTime = updatedRestaurant.closeTime;
        }
    }
}
