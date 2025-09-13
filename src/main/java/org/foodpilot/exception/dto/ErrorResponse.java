package org.foodpilot.exception.dto;

public class ErrorResponse {
    public String message;
    public int status;
    public long timestamp;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }
}
