package com.example.soap.config;

import com.example.soap.client.CalculatorSOAPClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SOAPConfiguration {

    private final static String WSDL_PATH = "com.example.soap.wsdl";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(WSDL_PATH);
        System.out.println("ctx path: " + marshaller.getContextPath());
        return marshaller;
    }

    @Bean
    public CalculatorSOAPClient calculatorSOAPClient(Jaxb2Marshaller marshaller) {
        CalculatorSOAPClient client = new CalculatorSOAPClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
