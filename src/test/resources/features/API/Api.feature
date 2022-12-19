Feature: API

  Background:
    Given I send a request to url

  @ASJ-21
  Scenario: GET existing courses
    Then Verify I can retrieve SDET courses database with status code 200
    Then Verify I can retrieve Dev courses database with status code 200
    Then Verify Response Body Contains "id", "name", and "duration"

  @ASJ-28
  Scenario: Admins info in db
    Then Verify I can retrieve admin info database with status code "200"
    Then Verify Admins Info DB Response Body Contains "firstName", "lastName", and "email"
