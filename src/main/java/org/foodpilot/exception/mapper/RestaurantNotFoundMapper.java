package org.foodpilot.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.foodpilot.exception.dto.ErrorResponse;
import org.foodpilot.exception.RestaurantNotFoundException;

@Provider
public class RestaurantNotFoundMapper implements ExceptionMapper<RestaurantNotFoundException> {

    @Override
    public Response toResponse(RestaurantNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), 404);
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}

