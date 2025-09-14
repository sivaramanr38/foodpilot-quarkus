package org.foodpilot.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.foodpilot.dto.RestaurantDTO;
import org.foodpilot.exception.RestaurantNotFoundException;
import org.foodpilot.service.RestaurantService;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Path("/restaurants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantResource {

    @Inject
    RestaurantService restaurantService;

    @GET
    public Response getAll() {
        List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();
        if (restaurants.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(restaurants).build();
    }

    @GET
    @Path("/{id}")
    public Response getRestaurantById(@PathParam("id") Long id) {
        Optional<RestaurantDTO> optionalRestaurant = restaurantService.getRestaurantById(id);
        if (optionalRestaurant.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        RestaurantDTO restaurant = optionalRestaurant.get();
        return Response.ok(restaurant).build();
    }

    @POST
    public Response addRestaurant(RestaurantDTO restaurantDTO) {
        if (restaurantDTO == null || restaurantDTO.getName() == null) {
            throw new IllegalArgumentException("Restaurant name is required");
        }

        // Add restaurant via service layer
        Long createdId = restaurantService.addRestaurant(restaurantDTO);

        // Build URI for the newly created resource
        URI location = URI.create("/restaurants/" + createdId);

        // Return 201 Created with Location header
        return Response.created(location).entity(Map.of("id", createdId)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRestaurant(@PathParam("id") Long id, RestaurantDTO updatedRestaurant) {
        if (updatedRestaurant == null || updatedRestaurant.getName() == null) {
            throw new IllegalArgumentException("Updated restaurant data is invalid");
        }

        boolean updated = restaurantService.updateRestaurant(id, updatedRestaurant);
        if(!updated) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        return Response.ok(Map.of("message", "Restaurant updated successfully")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRestaurant(@PathParam("id") Long id) {
        boolean deleted = restaurantService.deleteRestaurant(id);
        if (!deleted) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/cuisine")
    public Response getRestaurantByCuisine(@QueryParam("cuisineType") String cuisineType) {
        List<RestaurantDTO> restaurantDTOS = restaurantService.getRestaurantsByCuisine(cuisineType);
        if (restaurantDTOS.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found with cuisineType: " + cuisineType);
        }
        return Response.ok(restaurantDTOS).build();
    }

    @GET
    @Path("/openNow")
    public Response getOpenRestaurants(@QueryParam("page") @DefaultValue("0") int page,
                                       @QueryParam("size") @DefaultValue("10") int size) {
        List<RestaurantDTO> openRestaurants = restaurantService.getOpenRestaurants(page, size);
        if (openRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("No open restaurants found");
        }
        return Response.ok(openRestaurants).build();
    }

}
