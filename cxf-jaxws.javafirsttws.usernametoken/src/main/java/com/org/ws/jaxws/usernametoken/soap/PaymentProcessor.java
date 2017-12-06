package com.org.ws.jaxws.usernametoken.soap;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.org.ws.jaxws.usernametoken.dto.PaymentProcessorRequest;
import com.org.ws.jaxws.usernametoken.dto.PaymentProcessorResponse;

@WebService(serviceName = "PaymentProcessor")
public interface PaymentProcessor {

	public @WebResult(name = "response")
	PaymentProcessorResponse processPayment(
			@WebParam(name = "PaymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
