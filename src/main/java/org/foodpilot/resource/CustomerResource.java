package org.foodpilot.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.foodpilot.dto.CustomerDTO;
import org.foodpilot.service.CustomerService;

import java.util.List;

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
}
