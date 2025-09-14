package org.foodpilot.service;
import org.foodpilot.dto.RestaurantDTO;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<RestaurantDTO> getAllRestaurants();

    Optional<RestaurantDTO> getRestaurantById(Long id);

    long addRestaurant(RestaurantDTO restaurant);

    boolean updateRestaurant(Long id, RestaurantDTO updatedRestaurant);

    boolean deleteRestaurant(Long id);

    List<RestaurantDTO> getRestaurantsByCuisine(String cuisineType);

    List<RestaurantDTO> getOpenRestaurants(int page, int size);
}
