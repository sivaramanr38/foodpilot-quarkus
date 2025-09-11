package org.foodpilot.mapper;

import org.foodpilot.dto.RestaurantDTO;
import org.foodpilot.model.Restaurant;

public class RestaurantMapper {

    public static RestaurantDTO toDTO(Restaurant entity) {
        if (entity == null) return null;

        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCuisineType(entity.getCuisineType());
        dto.setLocation(entity.getLocation());
        dto.setRatings(entity.getRatings());
        dto.setRatingsCount(entity.getRatingsCount());
        dto.setPromotions(entity.getPromotions());
        dto.setFreeDelivery(entity.getFreeDelivery());
        dto.setDineIn(entity.getDineIn());
        dto.setTakeaway(entity.getTakeaway());
        dto.setOpenTime(entity.getOpenTime());
        dto.setCloseTime(entity.getCloseTime());
        return dto;
    }

    public static Restaurant toEntity(RestaurantDTO dto) {
        if (dto == null) return null;

        Restaurant entity = new Restaurant();
        entity.setName(dto.getName());
        entity.setCuisineType(dto.getCuisineType());
        entity.setLocation(dto.getLocation());
        entity.setRatings(dto.getRatings());
        entity.setRatingsCount(dto.getRatingsCount());
        entity.setPromotions(dto.getPromotions());
        entity.setFreeDelivery(dto.getFreeDelivery());
        entity.setDineIn(dto.getDineIn());
        entity.setTakeaway(dto.getTakeaway());
        entity.setOpenTime(dto.getOpenTime());
        entity.setCloseTime(dto.getCloseTime());
        return entity;
    }

    public static void updateEntityFromDTO(Restaurant entity, RestaurantDTO dto) {
        if (entity == null || dto == null) return;

        entity.setName(dto.getName());
        entity.setCuisineType(dto.getCuisineType());
        entity.setLocation(dto.getLocation());
        entity.setRatings(dto.getRatings());
        entity.setRatingsCount(dto.getRatingsCount());
        entity.setPromotions(dto.getPromotions());
        entity.setFreeDelivery(dto.getFreeDelivery());
        entity.setDineIn(dto.getDineIn());
        entity.setTakeaway(dto.getTakeaway());
        entity.setOpenTime(dto.getOpenTime());
        entity.setCloseTime(dto.getCloseTime());
    }
}
