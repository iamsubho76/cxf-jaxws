package com.org.ws.jaxws.javafirstws.soap;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.org.ws.jaxws.javafirstws.dto.PaymentProcessorRequest;
import com.org.ws.jaxws.javafirstws.dto.PaymentProcessorResponse;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

	public @WebResult(name = "response") PaymentProcessorResponse processPayment(
			@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
