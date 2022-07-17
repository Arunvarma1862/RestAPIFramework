package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class utlis {

	public static RequestSpecification  req;
	public static ResponseSpecification resp;
	public static Response	response ;
	
	 
	 
	public RequestSpecification SpecRequest() throws Exception {
	
		if(req==null)
		{
		FileOutputStream fos = new FileOutputStream("logging.txt");
		PrintStream log = new PrintStream(fos);
		
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		
	    req  =	new RequestSpecBuilder().setBaseUri(getGlobalValues("baseuri"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON)
				. build();
	    
	    return req;
		}
		return req;
	}
	
	public  ResponseSpecification specResponse() {
		
		 resp  =  new ResponseSpecBuilder().expectStatusCode(200)
	                .expectContentType(ContentType.JSON).build();
		 
		 return resp;
	}
	public static String getGlobalValues(String key) throws Exception {
		
		File file= new File("C:\\eclipse project\\APIFramework\\src\\test\\java\\resources\\global.properties");
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(file);
		pro.load(fis);
	    return	pro.getProperty(key);
		
	
	}
	public String getJson(String key) {
		 
		String status = response.asString();
		JsonPath js= new JsonPath(status);
		return js.get(key).toString();
	}
}
