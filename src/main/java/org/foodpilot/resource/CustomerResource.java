package org.foodpilot.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.foodpilot.dto.CustomerDTO;
import org.foodpilot.exception.CustomerNotFoundException;
import org.foodpilot.service.CustomerService;
import org.h2.util.StringUtils;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Tag(name = "Customer", description = "Operations related to customer data")
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    @Operation(summary = "Get all customers", description = "Returns a list of all available customers")
    @APIResponse(responseCode = "200", description = "List of restaurants")
    @APIResponse(responseCode = "204", description = "No customer found")
    public Response getAll(){
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        if(customerDTOList.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(customerDTOList).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get customer by ID", description = "Returns a customer by its unique ID")
    @APIResponse(responseCode = "200", description = "Customer found")
    @APIResponse(responseCode = "404", description = "Customer not found")
    public Response getCustomerById(@Parameter(description = "ID of the customer", example = "101") @PathParam("id")  Long id){
        Optional<CustomerDTO> customerDTO = customerService.getCustomerById(id);
        if(customerDTO.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
        return Response.ok(customerDTO.get()).build();
    }

    @POST
    @Operation(summary = "Add a new customer and return its id", description = "Creates a new customer and returns its ID")
    @APIResponse(responseCode = "201", description = "Customer created successfully")
    @APIResponse(responseCode = "400", description = "Invalid customer data")
    public Response addCustomer(@Parameter(description = "Customer data to create") CustomerDTO customerDTO) {
        if(customerDTO == null || customerDTO.getFirstName() == null) {
           throw new IllegalArgumentException("Customer name is required");
        }
        Long createdId = customerService.addCustomer(customerDTO);
        URI location = URI.create("/customer/" + createdId);
        return Response.created(location).entity(Map.of("id", createdId)).build();
    }

    @POST
    @Path("/{id}")
    @Operation(summary = "Customer update", description = "Updates an existing customer by ID")
    @APIResponse(responseCode = "200", description = "Customer updated successfully")
    @APIResponse(responseCode = "404", description = "Customer not found")
    @APIResponse(responseCode = "400", description = "Invalid update data")
    public Response updateCustomer(
            @Parameter(description = "ID of the customer to update", example = "101") @PathParam("id") Long id,
            @Parameter(description = "Updated customer data")  CustomerDTO customerDTO) {
        if(customerDTO == null || customerDTO.getFirstName() == null) {
            throw new IllegalArgumentException("Customer name is required");
        }
        boolean updated = customerService.updateCustomer(id, customerDTO);
        if(!updated) {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
        return Response.ok(Map.of("message", "Restaurant updated successfully")).build();
    }

    @DELETE
    @Path("{/id}")
    @Operation(summary = "Delete customer", description = "Deletes a customer by its ID")
    @APIResponse(responseCode = "204", description = "Customer deleted successfully")
    @APIResponse(responseCode = "404", description = "Customer not found")
    public Response deleteCustomer(
            @Parameter(description = "ID of the customer to delete", example = "101")@PathParam("id") Long id) {
        boolean deleted = customerService.deleteCustomer(id);
        if(!deleted) {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
        return Response.noContent().build();
    }

    @GET
    @Path("{/email}")
    @Operation(summary = "Get Cutomer by email", description = "Retrieves a customer by its ID")
    @APIResponse(responseCode = "404", description = "Customer not found")
    @APIResponse(responseCode = "200", description = "Customer retrieved successfully")
    public Response getCustomerByEmail(@PathParam("email") String email) {
        if(StringUtils.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("Customer email is required");
        }
        CustomerDTO customerDTO = customerService.getCustomerByEmail(email);
        if(customerDTO == null) {
            throw new CustomerNotFoundException("Customer not found with email: " + email);
        }
        return Response.ok(customerDTO).build();
    }
}
