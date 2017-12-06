package com.org.ws.jaxws.mtom;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FileUpload {

	void uploadFile(@WebParam(name = "file") DataHandler attachinfo);

	DataHandler downloadFile();

}
