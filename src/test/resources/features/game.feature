@unit @regression @functional
Feature: Functional Tests

  @functional-Unit
  Scenario Outline: Functional Tests JUnit
    When I enter <gameName> test
    Then I verify text
    Examples:
      | gameName|
      |Chess|
      |Basket Bool|
      |Football|

  @functional-Unit-CheckID
  Scenario: Functional Tests JUnit Check ID
    Then I verify enter ID 30 times

  @functional-Unit-Failure
  Scenario: Functional Tests JUnit Failure test
    Then I Test Failure text
    Then I verify Failure text

  @functional-Unit-blank
  Scenario: Functional Tests JUnit blank
    Then I Test blank text
    Then I verify text