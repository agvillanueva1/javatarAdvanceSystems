Feature: API

  Background:
    Given I send a request to url

  @ASJ-21 @API
  Scenario: GET existing courses
    Given I send a request to url
    Then Verify I can retrieve SDET courses database with status code "200"
    Then Verify I can retrieve Dev courses database with status code "200"
    Then Verify Response Body Contains "id", "name", and "duration"

  @ASJ-28 @API
  Scenario: Admins info in db
    Then Verify I can retrieve admin info database with status code "200"
    Then Verify Admins Info DB Response Body Contains "firstName", "lastName", and "email"

  @ASJ-27 @API
  Scenario: Bearer token retrieval
    When User adds basic auth with username "user" and password "user123"
    And User send GET request to the endpoint "/api/school/departments/gettoken"
    Then response should contain a token "token"
