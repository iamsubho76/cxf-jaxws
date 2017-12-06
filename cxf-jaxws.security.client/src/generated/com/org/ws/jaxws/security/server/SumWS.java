package com.org.ws.jaxws.security.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.9
 * 2017-12-06T10:20:15.724+05:30
 * Generated source version: 3.1.9
 * 
 */
@WebService(targetNamespace = "http://server.security.jaxws.ws.org.com/", name = "SumWS")
@XmlSeeAlso({ObjectFactory.class})
public interface SumWS {

    @WebMethod
    @RequestWrapper(localName = "calculate", targetNamespace = "http://server.security.jaxws.ws.org.com/", className = "com.org.ws.jaxws.security.server.Calculate")
    @ResponseWrapper(localName = "calculateResponse", targetNamespace = "http://server.security.jaxws.ws.org.com/", className = "com.org.ws.jaxws.security.server.CalculateResponse")
    @WebResult(name = "response", targetNamespace = "")
    public com.org.ws.jaxws.security.server.SumResponse calculate(
        @WebParam(name = "arg0", targetNamespace = "")
        com.org.ws.jaxws.security.server.SumRequest arg0
    );
}
