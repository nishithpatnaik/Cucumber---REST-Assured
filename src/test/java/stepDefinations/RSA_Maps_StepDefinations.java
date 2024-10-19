package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.Utils;

public class RSA_Maps_StepDefinations extends Utils
{
	
	
	
	Response res;	
	@Given("Add Place Params and Payload")
	public void add_place_params_and_payload() throws FileNotFoundException 
	{
	    // Write code here that turns the phrase above into concrete actions
		
		String RequestBody = "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
		
		
		//POST METHOD - CREATE AN ADDRESS
		
		Req = given().spec(requestSpecification()).
				log().all().
				queryParam("key", "31").
				header("Content-Type","application/json").
				body(RequestBody.toString());
					
		
	    
	}
	
	
	@When("User calls the {string} call")
	public void user_calls_the_call(String string) throws FileNotFoundException 
	{
	    // Write code here that turns the phrase above into concrete actions
		 res = Req.
				 	when().
				 		post("/maps/api/place/add/json").
				 	then().
					//assertThat().
				 		statusCode(200).
					//Validating Body Nodes
				 		body("scope", equalTo("APP")).
				 		body("status", equalTo("OK")).
					//Validation on Header Nodes
					//Response header validation
				 		header("Content-Type", "application/json;charset=UTF-8").
					//Log to console
				 		log().all().extract().response();

	
	}
	
	
	@Then("The API call is successful with Status Code of {int}")//{int} here receives 200 from the Scenario
	public void the_api_call_is_successful_with_status_code_of(Integer int1) 
	{
	    // Write code here that turns the phrase above into concrete actions
		
		assertEquals(res.getStatusCode(),200);	//{int} is 200
		

	}
	
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String jsonfield, String expectedvalue) //receving params from scenario in feature file
	{
	    // Write code here that turns the phrase above into concrete actions
		String responstr = res.asString();
		JsonPath jp = new JsonPath(responstr);
		assertEquals(jp.getString(jsonfield),expectedvalue); //this will check if status == OK or not
		
	 
	}
	
}
