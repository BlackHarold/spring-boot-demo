package com.example.soap.validator;

import com.example.soap.model.OperationRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RequestValidator implements Validator {
    private final static String VALUE_SHOULD_HAVE_TYPE_INT = "значение должно иметь тип int";
    private final static String VALUE_MUST_NOT_BE_NULL = "значение не может отсутствовать";
    private final static String VALUE_CANNOT_BE_EMPTY = "значение не может быть пустым";
    private final static String VALUE_NEGATIVE = "value.negative";
    private final static String FIRST_NUMBER = "firstNumber";
    private final static String SECOND_NUMBER = "secondNumber";
    private final static String VALUE_EMPTY = "";


    @Override
    public boolean supports(Class<?> aClass) {
        return OperationRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        OperationRequest request = (OperationRequest) obj;
        fieldValidate(FIRST_NUMBER, request.getFirstNumber(), errors);
        fieldValidate(SECOND_NUMBER, request.getSecondNumber(), errors);
    }

    private void fieldValidate(String fieldName, String fieldValue, Errors errors) {
        if (fieldValue == null) {
            errors.rejectValue(fieldName, VALUE_NEGATIVE, VALUE_MUST_NOT_BE_NULL);
        } else if (fieldValue.equals(VALUE_EMPTY)) {
            errors.rejectValue(fieldName, VALUE_NEGATIVE, VALUE_CANNOT_BE_EMPTY);
        } else if (!isInteger(fieldValue)) {
            errors.rejectValue(fieldName, VALUE_NEGATIVE, VALUE_SHOULD_HAVE_TYPE_INT);
        }
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
