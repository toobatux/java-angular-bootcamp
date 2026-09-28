package com.northstar.crm.exception;

import jakarta.validation.ConstraintViolation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GlobalExceptionHandler {

    public ErrorResponse fromBusiness(BusinessException ex) {
        // TODO: map statusHint / code / message / correlationId; errors = empty map
        return new ErrorResponse(
                ex.getStatusHint(),
                ex.getCode(),
                ex.getMessage(),
                ex.getCorrelationId(),
                new ArrayList<>()
        );
    }

    public ErrorResponse fromValidation(
            Set<? extends ConstraintViolation<?>> violations, String correlationId) {
        // TODO: status 400 VALIDATION_FAILED with field → message map
        Map<String, String> fields = new HashMap<>();
        for (ConstraintViolation violation : violations) {
            fields.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return new ErrorResponse(
                400,
                "VALIDATION_FAILED",
                "Validation failed",
                correlationId,
                new ArrayList<>()
        );
    }

    public ErrorResponse fromUnexpected(Exception ex, String correlationId) {
        // TODO: status 500 INTERNAL_ERROR generic message (no stack / no ex.getMessage leak)
        throw new UnsupportedOperationException("TODO: fromUnexpected");
    }
}
