Feature: API

  @ASJ-21
  Scenario: GET existing courses
    Given I send a request to url
    Then Verify I can retrieve SDET courses database with status code "200"
    Then Verify I can retrieve Dev courses database with status code "200"
    Then Verify Response Body Contains "id", "name", and "duration"