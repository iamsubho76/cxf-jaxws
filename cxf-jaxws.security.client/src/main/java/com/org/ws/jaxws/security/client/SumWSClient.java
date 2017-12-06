package com.org.ws.jaxws.security.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.org.ws.jaxws.security.client.ut.PasswordCallbackHandler;
import com.org.ws.jaxws.security.server.SumRequest;
import com.org.ws.jaxws.security.server.SumResponse;
import com.org.ws.jaxws.security.server.SumWS;
import com.org.ws.jaxws.security.server.SumWSService;

public class SumWSClient {
	public static void main(String[] args) {
		SumWSService service;
		try {
			service = new SumWSService(new URL("http://localhost:8086/cxf-jaxws.security.server/services/sumWS?wsdl"));
			SumWS port = service.getSumWSPort();

			// start for UsernameToken
			Client client = ClientProxy.getClient(port);
			Endpoint endpoint = client.getEndpoint();

			HashMap<String, Object> outProperties = new HashMap<>();
			outProperties.put(WSHandlerConstants.ACTION, "UsernameToken Encrypt Signature Timestamp");
			outProperties.put(WSHandlerConstants.USER, "sumuser");
			outProperties.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			outProperties.put(WSHandlerConstants.PW_CALLBACK_CLASS, PasswordCallbackHandler.class.getName());
			
			outProperties.put(WSHandlerConstants.ENCRYPTION_USER, "myservicekey");
			outProperties.put(WSHandlerConstants.ENC_PROP_FILE, "properties/clientKeyStore.properties");
			outProperties.put(WSHandlerConstants.ENCRYPTION_PARTS, "{Element}{http://www.w3.org./2000/09/xmldsig#}Signature;{Content}{http://schemas.xnlsoap.org/soap/envelope}Body");
			
			outProperties.put(WSHandlerConstants.SIGNATURE_USER, "myclientkey");
			outProperties.put(WSHandlerConstants.SIG_PROP_FILE, "properties/clientKeyStore.properties");

			outProperties.put("timeToLive", 30);
			WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProperties);
			endpoint.getOutInterceptors().add(wssOut);

			HashMap<String, Object> inProperties = new HashMap<>();
			inProperties.put(WSHandlerConstants.ACTION, "Encrypt Signature Timestamp");
			inProperties.put(WSHandlerConstants.DEC_PROP_FILE, "properties/clientKeyStore.properties");
			outProperties.put(WSHandlerConstants.PW_CALLBACK_CLASS, PasswordCallbackHandler.class.getName());
			
			inProperties.put(WSHandlerConstants.SIG_PROP_FILE, "properties/clientKeyStore.properties");


			WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProperties);
			endpoint.getInInterceptors().add(wssIn);
			// end of UsernameToken

			SumRequest request = new SumRequest();
			request.setNum1(10);
			request.setNum2(10);
			SumResponse result = port.calculate(request);
			System.out.println(result.getResult());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
