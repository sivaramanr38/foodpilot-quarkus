package org.foodpilot.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalTime;

@Schema(description = "Represents a restaurant with its details")
public class RestaurantDTO {

        @Schema(description = "Unique identifier of the restaurant", example = "101")
        private Long id;

        @Schema(description = "Name of the restaurant", example = "Spice Garden")
        private String name;

        @Schema(description = "Type of cuisine served", example = "Indian")
        private String cuisineType;

        @Schema(description = "Location of the restaurant", example = "Koramangala, Bangalore")
        private String location;

        @Schema(description = "Average rating of the restaurant", example = "4.5")
        private BigDecimal ratings;

        @Schema(description = "Total number of ratings received", example = "250")
        private Integer ratingsCount;

        @Schema(description = "Current promotions available", example = "20% off on orders above ₹500")
        private String promotions;

        @Schema(description = "Indicates if free delivery is available", example = "true")
        private Boolean freeDelivery;

        @Schema(description = "Indicates if dine-in is available", example = "true")
        private Boolean dineIn;

        @Schema(description = "Indicates if takeaway is available", example = "false")
        private Boolean takeaway;

        @Schema(description = "Opening time of the restaurant", example = "10:00")
        private LocalTime openTime;

        @Schema(description = "Closing time of the restaurant", example = "22:30")
//      You can also use @Schema(hidden = true) to exclude fields from the documentation if needed.
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
