package stepDefintions;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.specification.RequestSpecification;
import resources.ApiResources;
import resources.TestData;
import resources.utlis;

@RunWith(Cucumber.class)
public class stepdefini  extends utlis  {
	
	RequestSpecification res;
	//Response	response;
	static String placeID;
	TestData td= new TestData();
	
	


	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws Exception {

		res =  given().spec(SpecRequest())                      
				.body(td.addPlacePayLoad(name,language,address));

	
	}


	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String http) {
		
	//Constructor will be called with value of resource which you pass	
		
		
		ApiResources resAPI= ApiResources.valueOf(resource);
	    System.out.println(resAPI.getResources());
		
	    
	    if(http.equalsIgnoreCase("POST"))
		     response=	res.when().post(resAPI.getResources());
		else if(http.equalsIgnoreCase("GET"))
		    response=	res.when().get(resAPI.getResources());
		else if(http.equalsIgnoreCase("DELETE"))
			response=	res.when().delete(resAPI.getResources());
		else if(http.equalsIgnoreCase("PUT"))
			response=	res.when().put(resAPI.getResources());
	    
	    
				//.then().spec(specResponse()).extract().response();

	
	}

	@Then("^the API call is success with status code 200$")
	public void the_api_call_is_success_with_status_code_200() throws Throwable {

		assertEquals(response.statusCode(),200);
		
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void something_in_response_body_is_something(String keyvalue, String Expectedvalue) throws Throwable {
	
	 
		 assertEquals(getJson(keyvalue),Expectedvalue);  
		
	}

   @Then("verify place_id created maps to{string} using {string}")
   public void verify_place_id_created_maps_to_arya_using(String expectedName,String resource) throws Exception {
    
    // requestSpec
	   
	     placeID=  getJson(	"place_id");
	     res =  given().spec(SpecRequest()).queryParam("place_id", placeID) ;  
	     user_calls_with_http_request( resource, "GET");
	     String name=  getJson(	"name");
	     assertEquals(name,expectedName);
}
   @Given("DeletePlace payLoad")
   public void delete_place_pay_load() throws Exception {
      res =given().spec(SpecRequest()).body(td.deletePlace(placeID));
   }

}

