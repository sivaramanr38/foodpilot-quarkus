package org.foodpilot.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Data Transfer Object representing a customer")
public class CustomerDTO {

    @Schema(description = "Unique identifier of the customer", example = "501")
    private Long id;

    @Schema(description = "First name of the customer", example = "Arjun", required = true)
    private String firstName;

    @Schema(description = "Last name of the customer", example = "Reddy", required = true)
    private String lastName;

    @Schema(description = "Email address of the customer", example = "arjun.reddy@example.com", required = true)
    private String email;

    @Schema(description = "Phone number of the customer", example = "+91-9876543210")
    private String phoneNumber;

    @Schema(description = "Full address of the customer", example = "123 MG Road, Indiranagar, Bangalore")
    private String address;

    @Schema(description = "Postal pincode for delivery", example = "560038")
    private String pincode;

    @Schema(description = "Timestamp of customer registration", example = "2025-09-21T18:45:00")
    private LocalDateTime registeredAt;

    @Schema(description = "Indicates if the customer account is active", example = "true")
    private Boolean isActive;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String firstName, String lastName, String email,
                       String phoneNumber, String address, String pincode,
                       LocalDateTime registeredAt, Boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.pincode = pincode;
        this.registeredAt = registeredAt;
        this.isActive = isActive;
    }

    // Getters and Setters

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
