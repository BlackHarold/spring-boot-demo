package com.example.soap.service.impl;

import com.example.soap.client.CalculatorSOAPClient;
import com.example.soap.exception.SoapResultException;
import com.example.soap.wsdl.*;
import com.example.soap.service.CalcService;
import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

    private static final String NO_RESULT_IN_RESPONSE_FROM_SOAP_CALCULATOR_SERVICE = "Empty SOAP response";

    private CalculatorSOAPClient calculatorSOAPClient;

    public CalcServiceImpl(CalculatorSOAPClient calculatorSOAPClient) {
        this.calculatorSOAPClient = calculatorSOAPClient;
    }

    public int add(int firstNumber, int secondNumber) {
        Add add = new Add();
        add.setIntA(firstNumber);
        add.setIntB(secondNumber);
        AddResponse response = calculatorSOAPClient.add(add);

        if (response == null)
            throw new SoapResultException(
                    new Error(NO_RESULT_IN_RESPONSE_FROM_SOAP_CALCULATOR_SERVICE)
            );

        return response.getAddResult();
    }

    public int divide(int firstNumber, int secondNumber) {
        Divide divide = new Divide();
        divide.setIntA(firstNumber);
        divide.setIntB(secondNumber);
        DivideResponse response = calculatorSOAPClient.divide(divide);

        if (response == null)
            throw new SoapResultException(
                    new Error(NO_RESULT_IN_RESPONSE_FROM_SOAP_CALCULATOR_SERVICE)
            );

        return response.getDivideResult();
    }

    public int multiply(int firstNumber, int secondNumber) {
        Multiply multiply = new Multiply();
        multiply.setIntA(firstNumber);
        multiply.setIntB(secondNumber);
        MultiplyResponse response = calculatorSOAPClient.multiply(multiply);

        if (response == null)
            throw new SoapResultException(
                    new Error(NO_RESULT_IN_RESPONSE_FROM_SOAP_CALCULATOR_SERVICE)
            );

        return response.getMultiplyResult();
    }

    public int subtract(int firstNumber, int secondNumber) {
        Subtract subtract = new Subtract();
        subtract.setIntA(firstNumber);
        subtract.setIntB(secondNumber);
        SubtractResponse response = calculatorSOAPClient.subtract(subtract);

        if (response == null)
            throw new SoapResultException(
                    new Error(NO_RESULT_IN_RESPONSE_FROM_SOAP_CALCULATOR_SERVICE)
            );

        return response.getSubtractResult();
    }

}
