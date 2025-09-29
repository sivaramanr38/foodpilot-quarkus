package org.foodpilot.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.foodpilot.dto.CustomerDTO;
import org.foodpilot.mapper.CustomerMapper;
import org.foodpilot.repository.CustomerRepository;
import org.foodpilot.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    @Inject
    CustomerRepository customerRepository;

    /**
     * @return
     */
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.listAll().stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
