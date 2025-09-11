package org.foodpilot.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.foodpilot.dto.RestaurantDTO;
import org.foodpilot.model.Restaurant;
import org.foodpilot.service.RestaurantService;

import java.util.List;

@Path("/restaurants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantResource {

    @Inject
    RestaurantService restaurantService;

    @GET
    public List<RestaurantDTO> getAll() {
        return restaurantService.getAllRestaurants();
    }
}
