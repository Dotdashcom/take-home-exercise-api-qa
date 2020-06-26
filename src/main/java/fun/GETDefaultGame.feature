Feature: Validate default game attributes

Background:
	 Given user sets the API header
   And user retrieves a game
	 And HTTP status code is 200 for the API response
   And user validates the returned id is an integer
   And user validates id is present
   And user validates text is present
  
@DefaultGameTest
  Scenario: This test validates the default game
   Then user validates text equals to "Playing Sudoku is fun!"
	 When request is sent the id is incremented and is fibonnaci