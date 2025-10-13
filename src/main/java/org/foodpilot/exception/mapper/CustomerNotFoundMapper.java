package org.foodpilot.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.foodpilot.exception.CustomerNotFoundException;
import org.foodpilot.exception.dto.ErrorResponse;

@Provider
public class CustomerNotFoundMapper implements ExceptionMapper<CustomerNotFoundException> {

    /**
     * Map an exception to a {@link Response}. Returning {@code null} results in a
     * {@link Response.Status#NO_CONTENT} response. Throwing a runtime exception results in a
     * {@link Response.Status#INTERNAL_SERVER_ERROR} response.
     *
     * @param exception the exception to map to a response.
     * @return a response mapped from the supplied exception.
     */
    @Override
    public Response toResponse(CustomerNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(exception.getMessage(), 404);
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
