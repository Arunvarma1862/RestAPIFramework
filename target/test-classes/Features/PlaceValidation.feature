Feature: Validating Place API's
@AddPlace
Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
Given Add place Payload with "<name>" "<language>" "<address>"
When user calls "AddplaceAPI" with "POST" http request
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And  verify place_id created maps to"<name>" using "GetplaceAPI"


Examples:

  |name   | language| address|
  |Arya  |french lag   |world famous lover|
#  |Arya-2|English|sea world famous lover|

@DeletePlace
Scenario: Verify if Delete Place functionality is working

Given DeletePlace payLoad
When user calls "DeleteplaceAPI" with "DELETE" http request
Then the API call is success with status code 200
And "status" in response body is "OK"
