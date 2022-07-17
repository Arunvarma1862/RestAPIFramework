package resources;

public enum ApiResources {
	
	// enum is special class in java which has collection of constants or methods
	
	AddplaceAPI("/maps/api/place/add/json"),
	GetplaceAPI("/maps/api/place/get/json"),
	DeleteplaceAPI("/maps/api/place/delete/json");
	
	private String resource;             // global variable
	
	ApiResources(String resource)
	{
		this.resource=resource;          // this keyword referees to current class variable 
		
	}
	public String getResources() {
		return resource;
	}
}
