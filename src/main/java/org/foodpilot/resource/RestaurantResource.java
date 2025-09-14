package org.foodpilot.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.foodpilot.dto.RestaurantDTO;
import org.foodpilot.exception.RestaurantNotFoundException;
import org.foodpilot.service.RestaurantService;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Tag(name = "Restaurants", description = "Operations related to restaurant data")
@Path("/restaurants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantResource {

    @Inject
    RestaurantService restaurantService;

    @GET
    @Operation(summary = "Get all restaurants", description = "Returns a list of all available restaurants")
    @APIResponse(responseCode = "200", description = "List of restaurants")
    @APIResponse(responseCode = "204", description = "No restaurants found")
    public Response getAll() {
        List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();
        if (restaurants.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(restaurants).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get restaurant by ID", description = "Returns a restaurant by its unique ID")
    @APIResponse(responseCode = "200", description = "Restaurant found")
    @APIResponse(responseCode = "404", description = "Restaurant not found")
    public Response getRestaurantById(
            @Parameter(description = "ID of the restaurant", example = "101") @PathParam("id") Long id) {
        Optional<RestaurantDTO> optionalRestaurant = restaurantService.getRestaurantById(id);
        if (optionalRestaurant.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        return Response.ok(optionalRestaurant.get()).build();
    }

    @POST
    @Operation(summary = "Add a new restaurant", description = "Creates a new restaurant and returns its ID")
    @APIResponse(responseCode = "201", description = "Restaurant created successfully")
    @APIResponse(responseCode = "400", description = "Invalid restaurant data")
    public Response addRestaurant(
            @Parameter(description = "Restaurant data to create") RestaurantDTO restaurantDTO) {
        if (restaurantDTO == null || restaurantDTO.getName() == null) {
            throw new IllegalArgumentException("Restaurant name is required");
        }
        Long createdId = restaurantService.addRestaurant(restaurantDTO);
        URI location = URI.create("/restaurants/" + createdId);
        return Response.created(location).entity(Map.of("id", createdId)).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update restaurant", description = "Updates an existing restaurant by ID")
    @APIResponse(responseCode = "200", description = "Restaurant updated successfully")
    @APIResponse(responseCode = "404", description = "Restaurant not found")
    @APIResponse(responseCode = "400", description = "Invalid update data")
    public Response updateRestaurant(
            @Parameter(description = "ID of the restaurant to update", example = "101") @PathParam("id") Long id,
            @Parameter(description = "Updated restaurant data") RestaurantDTO updatedRestaurant) {
        if (updatedRestaurant == null || updatedRestaurant.getName() == null) {
            throw new IllegalArgumentException("Updated restaurant data is invalid");
        }
        boolean updated = restaurantService.updateRestaurant(id, updatedRestaurant);
        if (!updated) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        return Response.ok(Map.of("message", "Restaurant updated successfully")).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete restaurant", description = "Deletes a restaurant by its ID")
    @APIResponse(responseCode = "204", description = "Restaurant deleted successfully")
    @APIResponse(responseCode = "404", description = "Restaurant not found")
    public Response deleteRestaurant(
            @Parameter(description = "ID of the restaurant to delete", example = "101") @PathParam("id") Long id) {
        boolean deleted = restaurantService.deleteRestaurant(id);
        if (!deleted) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/cuisine")
    @Operation(summary = "Get restaurants by cuisine", description = "Returns restaurants filtered by cuisine type")
    @APIResponse(responseCode = "200", description = "List of matching restaurants")
    @APIResponse(responseCode = "404", description = "No restaurants found for the given cuisine")
    public Response getRestaurantByCuisine(
            @Parameter(description = "Cuisine type to filter by", example = "Italian") @QueryParam("cuisineType") String cuisineType) {
        List<RestaurantDTO> restaurantDTOS = restaurantService.getRestaurantsByCuisine(cuisineType);
        if (restaurantDTOS.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found with cuisineType: " + cuisineType);
        }
        return Response.ok(restaurantDTOS).build();
    }

    @GET
    @Path("/openNow")
    @Operation(summary = "Get currently open restaurants", description = "Returns a paginated list of restaurants that are open now")
    @APIResponse(responseCode = "200", description = "List of open restaurants")
    @APIResponse(responseCode = "404", description = "No open restaurants found")
    public Response getOpenRestaurants(
            @Parameter(description = "Page number", example = "0") @QueryParam("page") @DefaultValue("0") int page,
            @Parameter(description = "Page size", example = "10") @QueryParam("size") @DefaultValue("10") int size) {
        List<RestaurantDTO> openRestaurants = restaurantService.getOpenRestaurants(page, size);
        if (openRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("No open restaurants found");
        }
        return Response.ok(openRestaurants).build();
    }
}
