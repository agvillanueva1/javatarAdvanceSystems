Feature: About Us page tests

  Background: Navigate to Home page
    Given I open url of homepage

  @ASJ-29
  Scenario: About Us page Main Content
    Then I click on navBar "About Us"
    Then Verify About Us header "Welcome to Advance Systems LLC." is displayed
    Then verify section contain "name" and "title" of the person
