Feature: Validate game attributes when name is given
  
  Background:
   Given user sets the API header
	 And HTTP status code is 200 for the API response
   And user validates the returned id is an integer
   And user validates id is present
   And user validates text is present
   
	@NamedGameTest
  Scenario: This test validates the text value returns the game name
    When user passes game name parameter as "Chess"
    Then user validates that the response text reads "Playing Chess is fun!"

	