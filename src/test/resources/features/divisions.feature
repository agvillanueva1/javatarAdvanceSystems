Feature: Divisions page tests

  Background: Navigate to Home page
    Given I open url of homepage

  @ASJ-34
  Scenario Outline: Our Services page: Divisions
    When I click a button "services"
    Then Verify "<Services>" are displayed
    Examples:
      | Services               |
      | Finance                |
      | Information Technology |
      | Healthcare             |
      | Government Projects    |
      | Others                 |