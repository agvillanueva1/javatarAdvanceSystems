Feature: Home page tests

  Background: Navigate to Home page
    Given I open url of homepage

  @ASJ-6
  Scenario: Test title of the home page
    Then Verify title text is "Advance Systems - Home"