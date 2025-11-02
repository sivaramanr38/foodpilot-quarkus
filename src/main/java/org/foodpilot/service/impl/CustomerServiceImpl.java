package org.foodpilot.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.foodpilot.dto.CustomerDTO;
import org.foodpilot.dto.RestaurantDTO;
import org.foodpilot.mapper.CustomerMapper;
import org.foodpilot.model.Customer;
import org.foodpilot.repository.CustomerRepository;
import org.foodpilot.service.CustomerService;

import java.util.List;
import java.util.Optional;
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

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        return customerRepository.findByIdOptional(id)
                .map(CustomerMapper::toDTO);
    }

    /**
     * @param customerDTO
     * @return
     */
    @Override
    @Transactional
    public long addCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toEntity(customerDTO);
        customerRepository.persist(customer);
        return customer.getId();
    }

    /**
     * @param id
     * @param updatedCustomer
     * @return
     */
    @Override
    @Transactional
    public boolean updateCustomer(Long id, CustomerDTO updatedCustomer) {
        Customer customer = customerRepository.findById(id);
        if(customer == null) {
            return false;
        }
        CustomerMapper.updateEntityFromDTO(customer, updatedCustomer);
        return true;
    }

    /**
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean deleteCustomer(Long id) {
        return customerRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<CustomerDTO> getCustomerByEmail(Long id) {
        return Optional.empty();
    }

}
