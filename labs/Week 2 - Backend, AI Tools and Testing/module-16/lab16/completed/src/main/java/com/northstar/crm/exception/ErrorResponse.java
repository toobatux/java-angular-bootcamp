package com.northstar.crm.exception;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ErrorResponse {
    // TODO: fields timestamp, status, error, message, correlationId, errors (always present, maybe empty)
    // TODO: constructor + getters
    // TODO: toJson() that always includes errors:{}
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String correlationId;
    private List<BusinessException> errors;

    public ErrorResponse(int status, String error, String message, String correlationId, List<BusinessException> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.correlationId = correlationId;
        this.errors = (errors != null) ? errors : new ArrayList<>();
    }

    public String toJson() {
        StringBuilder errorsJson = new StringBuilder("[");
        for (int i = 0; i < errors.size(); i++) {
            BusinessException error = errors.get(i);
            errorsJson.append("{")
                      .append("\"code\":\"").append(error.getCode()).append("\",")
                      .append("\"message\":\"").append(error.getMessage()).append("\",")
                      .append("\"status\":").append(error.getStatusHint()).append(",")
                      .append("\"correlationId\":\"").append(error.getCorrelationId()).append("\"}")
                      .append(i < errors.size() - 1 ? "," : "");
        }
        errorsJson.append("]");
        return "{"
                + "\"timestamp\":\"" + timestamp + "\","
                + "\"status\":" + status + ","
                + "\"error\":\"" + error + "\","
                + "\"message\":\"" + message + "\","
                + "\"correlationId\":\"" + correlationId + "\","
                + "\"errors\":" + errorsJson
                + "}";
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public List<BusinessException> getErrors() {
        return errors;
    }
}
