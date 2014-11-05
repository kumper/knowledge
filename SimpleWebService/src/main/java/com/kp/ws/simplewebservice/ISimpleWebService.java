package com.kp.ws.simplewebservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ISimpleWebService {

	@WebMethod
	public String sayHello(@WebParam(name = "name") final String name);

	@WebMethod
	public String sayGoodbye();

}
