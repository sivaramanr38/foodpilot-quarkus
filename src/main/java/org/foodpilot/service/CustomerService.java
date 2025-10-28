package org.foodpilot.service;


import org.foodpilot.dto.CustomerDTO;
import org.foodpilot.dto.RestaurantDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    Optional<CustomerDTO> getCustomerById(Long id);

    long addCustomer(CustomerDTO customer);

    boolean updateCustomer(Long id, CustomerDTO updatedCustomer);

    boolean deleteCustomer(Long id);

}
