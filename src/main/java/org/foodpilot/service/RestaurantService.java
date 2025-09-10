package org.foodpilot.service;
import org.foodpilot.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    Optional<Restaurant> getRestaurantById(Long id);
    void addRestaurant(Restaurant restaurant);
    void deleteRestaurant(Long id);
    void updateRestaurant(Long id, Restaurant updatedRestaurant);
}
