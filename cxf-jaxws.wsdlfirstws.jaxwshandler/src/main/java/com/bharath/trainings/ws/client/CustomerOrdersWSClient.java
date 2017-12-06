package com.bharath.trainings.ws.client;

import java.math.BigInteger;

import java.net.MalformedURLException;

import java.net.URL;

import java.util.List;

import com.org.ws.jaxws.wsdlfirstws.CustomerOrdersPortType;
import com.org.ws.jaxws.wsdlfirstws.CustomerOrdersService;
import com.org.ws.jaxws.wsdlfirstws.GetOrdersRequest;
import com.org.ws.jaxws.wsdlfirstws.GetOrdersResponse;
import com.org.ws.jaxws.wsdlfirstws.Order;
import com.org.ws.jaxws.wsdlfirstws.Product;

public class CustomerOrdersWSClient {

	public static void main(String[] args) {

		try {

			CustomerOrdersService service = new CustomerOrdersService(
					new URL("http://localhost:8080/wsdlfirstws/services/customerOrders?wsdl"));

			CustomerOrdersPortType port = service.getCustomerOrdersPort();

			GetOrdersRequest request = new GetOrdersRequest();

			request.setCustomerId(BigInteger.valueOf(1));

			GetOrdersResponse response = port.getOrders(request);

			List<Order> orders = response.getOrder();

			for (Order order : orders) {

				List<Product> products = order.getProduct();

				for (Product product : products) {

					System.out.println("{Product Description " + product.getDescription());

					System.out.println("{Product Quantity " + product.getQuantity());

				}

			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

	}

}