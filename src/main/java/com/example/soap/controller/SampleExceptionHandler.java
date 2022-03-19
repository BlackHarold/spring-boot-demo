package com.example.soap.controller;

import com.example.soap.exception.RequestValueException;
import com.example.soap.exception.SoapResultException;
import com.example.soap.model.error.OperationErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
public class SampleExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RequestValueException.class)
    public final OperationErrorResponse handleOperationRequestValueException(RequestValueException e) {
        return new OperationErrorResponse(e.getErrors());
    }

    @ExceptionHandler(SoapResultException.class)
    public final OperationErrorResponse handleSoapResponseValueException(SoapResultException e) {
        List<Error> errors = new ArrayList();
        errors.add(e.getError());
        return new OperationErrorResponse(errors);
    }
}
