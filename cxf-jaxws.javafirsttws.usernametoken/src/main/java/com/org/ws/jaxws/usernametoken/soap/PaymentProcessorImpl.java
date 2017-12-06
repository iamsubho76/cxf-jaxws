package com.org.ws.jaxws.usernametoken.soap;

import com.org.ws.jaxws.usernametoken.dto.PaymentProcessorRequest;
import com.org.ws.jaxws.usernametoken.dto.PaymentProcessorResponse;


public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(
			PaymentProcessorRequest paymentProcessorRequest) {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		//Business Logic or a call  to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
