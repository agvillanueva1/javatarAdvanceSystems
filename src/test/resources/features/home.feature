Feature: Home page tests

  Background: Navigate to Home page
    Given I open url of homepage

  @ASJ-6
  Scenario: Test title of the home page
    Then Verify title text is "Advance Systems - Home"

  @ASJ-4
  Scenario: Verify Parallax section
    Then Verify header is displayed
    Then Verify description is displayed
    Then Verify a ReadMore button on first parallax is displayed
    When I click a button "Read More"
    Then Verify destination window has url as "https://tla-batch-6.github.io/advance-systems-test-b6/services.html"
    Then Verify second header is displayed
    Then Verify second description is displayed
    Then Verify a ReadMore button on second parallax is displayed
    And I click a button "Read More2"
    Then Verify destination window has url as "https://tla-batch-6.github.io/advance-systems-test-b6/services.html"
