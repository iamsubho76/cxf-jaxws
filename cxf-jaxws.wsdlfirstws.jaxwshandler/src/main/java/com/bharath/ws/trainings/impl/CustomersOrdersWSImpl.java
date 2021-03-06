package com.bharath.ws.trainings.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.HandlerChain;

import com.org.ws.jaxws.wsdlfirstws.CreateOrdersRequest;
import com.org.ws.jaxws.wsdlfirstws.CreateOrdersResponse;
import com.org.ws.jaxws.wsdlfirstws.CustomerOrdersPortType;
import com.org.ws.jaxws.wsdlfirstws.GetOrdersRequest;
import com.org.ws.jaxws.wsdlfirstws.GetOrdersResponse;
import com.org.ws.jaxws.wsdlfirstws.Order;
import com.org.ws.jaxws.wsdlfirstws.Product;

@HandlerChain(file = "soap-handler.xml")
public class CustomersOrdersWSImpl implements CustomerOrdersPortType {

	Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
	int currentCustomerId;

	public CustomersOrdersWSImpl() {
		init();
	}

	public void init() {
		List<Order> orders = new ArrayList<Order>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		Product product = new Product();
		product.setDescription("IPhone");
		product.setId("1");
		product.setQuantity(BigInteger.valueOf(3));

		order.getProduct().add(product);

		orders.add(order);
		customerOrders.put(BigInteger.valueOf(++currentCustomerId), orders);
	}

	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);

		GetOrdersResponse response = new GetOrdersResponse();
		List<Order> responseOrders = response.getOrder();
		for (Order order : orders) {
			responseOrders.add(order);
		}

		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		Order order = request.getOrder();

		List<Order> currentOrders = customerOrders.get(request.getCustomerId());
		currentOrders.add(order);
		CreateOrdersResponse createOrdersResponse = new CreateOrdersResponse();

		createOrdersResponse.setResult(true);
		return createOrdersResponse;
	}
}
