package org.foodpilot.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.foodpilot.dto.RestaurantDTO;
import org.foodpilot.mapper.RestaurantMapper;
import org.foodpilot.model.Restaurant;
import org.foodpilot.repository.RestaurantRepository;
import org.foodpilot.service.RestaurantService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class RestaurantServiceImpl implements RestaurantService {

    @Inject
    RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.listAll().stream()
                .map(RestaurantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RestaurantDTO> getRestaurantById(Long id) {
        return restaurantRepository.findByIdOptional(id)
                .map(RestaurantMapper::toDTO);
    }

    @Override
    @Transactional
    public long addRestaurant(RestaurantDTO restaurantDto) {
        Restaurant restaurant = RestaurantMapper.toEntity(restaurantDto);
        restaurantRepository.persist(restaurant);
        return restaurant.getId();
    }

    @Override
    @Transactional
    public boolean updateRestaurant(Long id, RestaurantDTO updatedRestaurant) {
        Restaurant existing = restaurantRepository.findById(id);
        if (existing == null) {
            return false;
        }
        RestaurantMapper.updateEntityFromDTO(existing, updatedRestaurant);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteRestaurant(Long id) {
        return restaurantRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<RestaurantDTO> getRestaurantsByCuisine(String cuisineType) {
        List<Restaurant> restaurants = restaurantRepository.getRestaurantsByCuisine(cuisineType);
        List<RestaurantDTO> restaurantDtos = restaurants
                .stream()
                .map(RestaurantMapper::toDTO)
                .collect(Collectors.toList());
        return restaurantDtos;
    }

    @Override
    @Transactional
    public List<RestaurantDTO> getOpenRestaurants(int page, int size) {
        List<Restaurant> restaurants = restaurantRepository.getOpenRestaurants(page, size);
        List<RestaurantDTO> restaurantDTOs = restaurants.stream()
                .map(RestaurantMapper::toDTO)
                .collect(Collectors.toList());
        return restaurantDTOs;
    }
}
