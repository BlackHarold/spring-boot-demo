package com.example.soap.controller;

import com.example.soap.exception.RequestValueException;
import com.example.soap.mapper.Mapper;
import com.example.soap.model.OperationRequest;
import com.example.soap.model.OperationResponse;
import com.example.soap.service.CalcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("calculator")
public class SampleController {
    private Validator requestValidator;

    private CalcService calcService;

    private Mapper mapper;

    public SampleController(CalcService calcService, Mapper mapper, @Qualifier("requestValidator") Validator requestValidator) {
        this.calcService = calcService;
        this.mapper = mapper;
        this.requestValidator = requestValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(requestValidator);
    }

    @PostMapping(path = "/add", produces = "application/json")
    public OperationResponse addNumbers(@RequestBody @Valid OperationRequest request, BindingResult bindingResult) {
        System.out.println("/add");
        if (bindingResult.hasErrors())
            throw new RequestValueException(
                    mapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );

        return new OperationResponse(
                calcService.add(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }

    @PostMapping(path = "/divide", produces = "application/json")
    public OperationResponse divideNumbers(@RequestBody @Valid OperationRequest request, BindingResult bindingResult) {
        System.out.println("/divide");
        if (bindingResult.hasErrors())
            throw new RequestValueException(
                    mapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );

        return new OperationResponse(
                calcService.divide(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }

    @PostMapping(path = "/multiply", produces = "application/json")
    public OperationResponse multiplyNumbers(@RequestBody @Valid OperationRequest request, BindingResult bindingResult) {
        System.out.println("/multiply");
        if (bindingResult.hasErrors())
            throw new RequestValueException(
                    mapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );

        return new OperationResponse(
                calcService.multiply(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }

    @PostMapping(path = "/subtract", produces = "application/json")
    public OperationResponse subtractNumbers(@RequestBody @Valid OperationRequest request, BindingResult bindingResult) {
        System.out.println("/substract");
        if (bindingResult.hasErrors())
            throw new RequestValueException(
                    mapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );

        return new OperationResponse(
                calcService.subtract(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }
}
