package stepDefintions;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Exception {
		
		// excute this code only when place id is null
		// write a code that will give you place id
		
		
		stepdefinition  m= new stepdefinition();
		if(stepdefinition.placeID==null)
		{	
		m.add_place_payload_with("shetty", "english", "delhi");
		m.user_calls_with_http_request("AddplaceAPI", "POST");
		m.verify_place_id_created_maps_to_arya_using("shetty", "GetplaceAPI");
		
		}
	}
}
