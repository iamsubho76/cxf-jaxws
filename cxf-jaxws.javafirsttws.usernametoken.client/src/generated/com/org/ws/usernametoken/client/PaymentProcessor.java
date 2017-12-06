package com.org.ws.usernametoken.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2017-12-04T01:51:27.248+05:30
 * Generated source version: 3.0.2
 * 
 */
@WebService(targetNamespace = "http://client.usernametoken.ws.org.com/", name = "PaymentProcessor")
@XmlSeeAlso({ObjectFactory.class})
public interface PaymentProcessor {

    @WebMethod
    @RequestWrapper(localName = "processPayment", targetNamespace = "http://client.usernametoken.ws.org.com/", className = "com.org.ws.usernametoken.client.ProcessPayment")
    @ResponseWrapper(localName = "processPaymentResponse", targetNamespace = "http://client.usernametoken.ws.org.com/", className = "com.org.ws.usernametoken.client.ProcessPaymentResponse")
    @WebResult(name = "response", targetNamespace = "")
    public com.org.ws.usernametoken.client.PaymentProcessorResponse processPayment(
        @WebParam(name = "PaymentProcessorRequest", targetNamespace = "")
        com.org.ws.usernametoken.client.PaymentProcessorRequest paymentProcessorRequest
    );
}