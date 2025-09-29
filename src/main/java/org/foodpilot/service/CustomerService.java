package org.foodpilot.service;


import org.foodpilot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

}
