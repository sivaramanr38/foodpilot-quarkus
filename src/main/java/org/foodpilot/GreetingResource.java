package org.foodpilot;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(name = "Greeting", description = "Simple greeting endpoint")
@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Say hello", description = "Returns a plain text greeting")
    @APIResponse(responseCode = "200", description = "Successful greeting response")
    public String hello() {
        return "Hello RESTEasy";
    }
}
