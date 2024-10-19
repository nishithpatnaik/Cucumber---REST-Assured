package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	protected RequestSpecification Req;
	public RequestSpecification requestSpecification() throws FileNotFoundException
	{
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt")); //Define a file which will be created for logging console output
		
		Req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addFilter(RequestLoggingFilter.logRequestTo(log)) // for logging requests
				.addFilter(ResponseLoggingFilter.logResponseTo(log)) // for logging responses
				.build();
		//adding comments
		return Req;
	}

}
