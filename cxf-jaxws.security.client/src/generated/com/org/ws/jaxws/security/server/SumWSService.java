package com.org.ws.jaxws.security.server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.9
 * 2017-12-06T10:20:15.774+05:30
 * Generated source version: 3.1.9
 * 
 */
@WebServiceClient(name = "SumWSService", 
                  wsdlLocation = "file:/C:/EASE%20Workspace/cxf-jaxws/cxf-jaxws.security.client/src/main/resources/sumService.wsdl",
                  targetNamespace = "http://server.security.jaxws.ws.org.com/") 
public class SumWSService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://server.security.jaxws.ws.org.com/", "SumWSService");
    public final static QName SumWSPort = new QName("http://server.security.jaxws.ws.org.com/", "SumWSPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/EASE%20Workspace/cxf-jaxws/cxf-jaxws.security.client/src/main/resources/sumService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SumWSService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/EASE%20Workspace/cxf-jaxws/cxf-jaxws.security.client/src/main/resources/sumService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SumWSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SumWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SumWSService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public SumWSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SumWSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SumWSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns SumWS
     */
    @WebEndpoint(name = "SumWSPort")
    public SumWS getSumWSPort() {
        return super.getPort(SumWSPort, SumWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SumWS
     */
    @WebEndpoint(name = "SumWSPort")
    public SumWS getSumWSPort(WebServiceFeature... features) {
        return super.getPort(SumWSPort, SumWS.class, features);
    }

}
