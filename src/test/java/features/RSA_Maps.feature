Feature: Validating RSA Maps Place API's

Scenario: Verify if new Place is being successfully added using Post call
		Given 	Add Place Params and Payload
		When 		User calls the "AddPlacePOSTAPI" call
		Then 		The API call is successful with Status Code of 200
		And 		"status" in response body is "OK"
		And     "scope" in response body is "APP"