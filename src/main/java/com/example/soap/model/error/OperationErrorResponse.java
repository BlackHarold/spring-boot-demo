package com.example.soap.model.error;

import java.util.List;

public class OperationErrorResponse {
    private List<java.lang.Error> errors;

    public OperationErrorResponse() {
    }

    public OperationErrorResponse(List<java.lang.Error> errorList) {
        this.errors = errorList;
    }

    public List<java.lang.Error> getErrors() {
        return errors;
    }

    public void setErrors(List<java.lang.Error> errors) {
        this.errors = errors;
    }
}
