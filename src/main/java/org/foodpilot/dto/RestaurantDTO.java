package org.foodpilot.dto;

import java.math.BigDecimal;
import java.time.LocalTime;

public class RestaurantDTO {

        private Long id;
        private String name;
        private String cuisineType;
        private String location;
        private BigDecimal ratings;
        private Integer ratingsCount;
        private String promotions;
        private Boolean freeDelivery;
        private Boolean dineIn;
        private Boolean takeaway;
        private LocalTime openTime;
        private LocalTime closeTime;

        public RestaurantDTO() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCuisineType() {
            return cuisineType;
        }

        public void setCuisineType(String cuisineType) {
            this.cuisineType = cuisineType;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public BigDecimal getRatings() {
            return ratings;
        }

        public void setRatings(BigDecimal ratings) {
            this.ratings = ratings;
        }

        public Integer getRatingsCount() {
            return ratingsCount;
        }

        public void setRatingsCount(Integer ratingsCount) {
            this.ratingsCount = ratingsCount;
        }

        public String getPromotions() {
            return promotions;
        }

        public void setPromotions(String promotions) {
            this.promotions = promotions;
        }

        public Boolean getFreeDelivery() {
            return freeDelivery;
        }

        public void setFreeDelivery(Boolean freeDelivery) {
            this.freeDelivery = freeDelivery;
        }

        public Boolean getDineIn() {
            return dineIn;
        }

        public void setDineIn(Boolean dineIn) {
            this.dineIn = dineIn;
        }

        public Boolean getTakeaway() {
            return takeaway;
        }

        public void setTakeaway(Boolean takeaway) {
            this.takeaway = takeaway;
        }

        public LocalTime getOpenTime() {
            return openTime;
        }

        public void setOpenTime(LocalTime openTime) {
            this.openTime = openTime;
        }

        public LocalTime getCloseTime() {
            return closeTime;
        }

        public void setCloseTime(LocalTime closeTime) {
            this.closeTime = closeTime;
        }
}
