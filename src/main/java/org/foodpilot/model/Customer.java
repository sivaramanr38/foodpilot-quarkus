package org.foodpilot.model;

import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@Schema(description = "Entity representing a customer in the system")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the customer", example = "501")
    public Long id;

    @Column(nullable = false, length = 50)
    @Schema(description = "First name of the customer", example = "Arjun", required = true)
    public String firstName;

    @Column(nullable = false, length = 50)
    @Schema(description = "Last name of the customer", example = "Reddy", required = true)
    public String lastName;

    @Column(nullable = false, unique = true, length = 100)
    @Schema(description = "Email address of the customer", example = "arjun.reddy@example.com", required = true)
    public String email;

    @Column(unique = true, length = 15)
    @Schema(description = "Phone number of the customer", example = "+91-9876543210")
    public String phoneNumber;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Schema(description = "Hashed password for authentication", example = "$2a$10$...")
    public String passwordHash;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Full address of the customer", example = "123 MG Road, Indiranagar, Bangalore")
    public String address;

    @Column(length = 10)
    @Schema(description = "Postal pincode for delivery", example = "560038")
    public String pincode;

    @Column(nullable = false)
    @Schema(description = "Timestamp of customer registration", example = "2025-09-21T18:45:00")
    public LocalDateTime registeredAt = LocalDateTime.now();

    @Column(nullable = false)
    @Schema(description = "Indicates if the customer account is active", example = "true")
    public Boolean isActive = true;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
