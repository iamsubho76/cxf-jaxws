package com.org.ws.jaxws.security.server;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.org.ws.jaxws.security.server.dto.SumRequest;
import com.org.ws.jaxws.security.server.dto.SumResponse;

@WebService(name="SumWS")
public interface SumWS {
	@WebResult(name="response")SumResponse calculate(@WebParam SumRequest request);
}
