Feature: Home page tests

  Background: Navigate to Home page
    Given I open url of homepage

  @ASJ-6
  Scenario: Test title of the home page
    Then Verify title text is "Advance Systems - Home"

    @ASJ-3
    Scenario: Contact info on main page
      Then Verify address "10090 Main Street" is displayed
      Then Verify address "Fairfax, VA, USA" is displayed
      Then Verify phone number "+1 703-831-3217" is displayed