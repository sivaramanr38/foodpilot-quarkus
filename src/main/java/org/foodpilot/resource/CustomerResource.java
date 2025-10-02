package org.foodpilot.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.foodpilot.dto.CustomerDTO;
import org.foodpilot.service.CustomerService;

import java.util.List;

@Tag(name = "Customer", description = "Operations related to customer data")
@Path("/customer")
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    public Response getAll(){
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        if(customerDTOList.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(customerDTOList).build();
    }
}
