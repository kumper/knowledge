package com.kp.ws.simplewebservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.util.StringUtils;

@WebService
public class SimpleWebServiceImpl implements ISimpleWebService {

	@WebMethod
	public String sayHello(@WebParam(name = "name") String name) {
		if (StringUtils.isEmpty(name)) {
			return "Hello world";
		}
		else {
			return "Hello " + name;
		}
	}

	@WebMethod
	public String sayGoodbye() {
		return "Goodbye!";
	}

}
