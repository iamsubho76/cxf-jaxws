package com.org.ws.jaxws.security.server.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SumResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SumResponse {
	@XmlElement(name = "result")
	private int result;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
