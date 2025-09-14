package org.foodpilot.exception.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Standard error response structure")
public class ErrorResponse {

    @Schema(description = "Error message describing the issue", example = "Restaurant not found with ID: 42")
    public String message;

    @Schema(description = "HTTP status code", example = "404")
    public int status;

    @Schema(description = "Timestamp when the error occurred (epoch milliseconds)", example = "1694700000000")
    public long timestamp;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }
}
