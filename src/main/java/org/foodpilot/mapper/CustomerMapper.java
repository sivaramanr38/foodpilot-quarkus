package org.foodpilot.mapper;

import org.foodpilot.dto.CustomerDTO;
import org.foodpilot.model.Customer;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer entity) {
        if (entity == null) return null;

        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAddress(entity.getAddress());
        dto.setPincode(entity.getPincode());
        dto.setRegisteredAt(entity.getRegisteredAt());
        dto.setIsActive(entity.getActive());
        return dto;
    }

    public static Customer toEntity(CustomerDTO dto) {
        if (dto == null) return null;

        Customer entity = new Customer();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setAddress(dto.getAddress());
        entity.setPincode(dto.getPincode());
        entity.setRegisteredAt(dto.getRegisteredAt());
        entity.setActive(dto.getIsActive());
        return entity;
    }

    public static void updateEntityFromDTO(Customer entity, CustomerDTO dto) {
        if (entity == null || dto == null) return;

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setAddress(dto.getAddress());
        entity.setPincode(dto.getPincode());
        entity.setRegisteredAt(dto.getRegisteredAt());
        entity.setActive(dto.getIsActive());
    }
}
