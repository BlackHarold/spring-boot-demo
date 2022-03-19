package com.example.soap.client;

import com.example.soap.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CalculatorSOAPClient extends WebServiceGatewaySupport {
    private final static String URI = "http://www.dneonline.com/calculator.asmx";
    private final static String HTTP_TEMP_URI_ORG_ADD = "add";
    private final static String HTTP_TEMP_URI_ORG_DIVIDE = "divide";
    private final static String HTTP_TEMP_URI_ORG_MULTIPLY = "multiply";
    private final static String HTTP_TEMP_URI_ORG_SUBTRACT = "subtract";

    public AddResponse add(Add addRequest) {
        return (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        URI,
                        addRequest,
                        new SoapActionCallback(HTTP_TEMP_URI_ORG_ADD)
                );
    }

    public DivideResponse divide(Divide divideRequest) {
        return (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        URI,
                        divideRequest,
                        new SoapActionCallback(HTTP_TEMP_URI_ORG_DIVIDE)
                );
    }

    public MultiplyResponse multiply(Multiply multiplyRequest) {
        return (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        URI,
                        multiplyRequest,
                        new SoapActionCallback(HTTP_TEMP_URI_ORG_MULTIPLY)
                );
    }

    public SubtractResponse subtract(Subtract subtractRequest) {
        return (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        URI,
                        subtractRequest,
                        new SoapActionCallback(HTTP_TEMP_URI_ORG_SUBTRACT)
                );
    }

}
