package com.org.ws.jaxws.security.server;

import com.org.ws.jaxws.security.server.dto.SumRequest;
import com.org.ws.jaxws.security.server.dto.SumResponse;

public class SumWSImpl implements SumWS {

	@Override
	public SumResponse calculate(SumRequest request) {
		System.out.println("Calculate of SumResponse has been invoked.");
		int result = request.getNum1() + request.getNum2();
		SumResponse resp = new SumResponse();
		resp.setResult(result);
		System.out.println("Result return is : " + result);
		return resp;
	}
}
