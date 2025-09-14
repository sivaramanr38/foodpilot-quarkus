package org.foodpilot.model;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "restaurant")
@Schema(description = "Entity representing a restaurant in the system")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the restaurant", example = "101")
    public Long id;

    @Column(nullable = false, length = 100)
    @Schema(description = "Name of the restaurant", example = "Spice Garden", required = true)
    public String name;

    @Column(length = 50)
    @Schema(description = "Type of cuisine served", example = "Indian")
    public String cuisineType;

    @Column(length = 150)
    @Schema(description = "Location of the restaurant", example = "Koramangala, Bangalore")
    public String location;

    @Column(precision = 3, scale = 2)
    @Schema(description = "Average rating of the restaurant", example = "4.5")
    public BigDecimal ratings;

    @Schema(description = "Total number of ratings received", example = "250")
    public Integer ratingsCount;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Current promotions available", example = "20% off on orders above ₹500")
    public String promotions;

    @Schema(description = "Indicates if free delivery is available", example = "true")
    public Boolean freeDelivery = false;

    @Schema(description = "Indicates if dine-in is available", example = "true")
    public Boolean dineIn = true;

    @Schema(description = "Indicates if takeaway is available", example = "true")
    public Boolean takeaway = true;

    @Schema(description = "Opening time of the restaurant", example = "10:00")
    public LocalTime openTime;

    @Schema(description = "Closing time of the restaurant", example = "22:30")
    public LocalTime closeTime;

    public Restaurant() {
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
