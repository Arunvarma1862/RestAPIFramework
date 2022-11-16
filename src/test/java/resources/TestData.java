package resources;

import java.util.ArrayList;
import java.util.List;


import pojo.AddPlace;
import pojo.getLocation;

public class TestData {

	
	public AddPlace addPlacePayLoad(String name, String language ,String address) {

    
		AddPlace ad= new AddPlace();
		
		ad.setAccuracy(50);
		ad.setAddress(address);
		ad.setWebsite("http://google.com");
		ad.setLanguage(language);
		ad.setName(name);
		ad.setPhone_number("(+91) 983 893 3937");

		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		ad.setTypes(myList);

		getLocation gl = new getLocation();
		gl.setLat(-38.383494);
		gl.setLng(33.427362);
		ad.setLocation(gl);
		
		return ad;
	}
	
	public String deletePlace(String placeid) {
		return "{\r\n    \"place_id\":\""+placeid+"\"\r\n}";
	}
}
