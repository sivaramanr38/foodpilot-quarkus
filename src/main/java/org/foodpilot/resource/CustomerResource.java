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
import org.foodpilot.exception.RestaurantNotFoundException;
import org.foodpilot.service.CustomerService;

import java.util.List;
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
}
