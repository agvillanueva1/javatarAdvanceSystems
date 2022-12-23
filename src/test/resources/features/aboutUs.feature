Feature: About Us page tests

  Background: Navigate to Home page
    Given I open url of homepage

  @ASJ-29
  Scenario: About Us page Main Content
    Then I click on navBar "About Us"
    Then Verify About Us header "Welcome to Advance Systems LLC." is displayed
    Then verify section contain "name" and "title" of the person

  @ASJ-31
  Scenario: About Us page: Employees
    When I click on navBar "About Us"
    Then Verify About Us header "Meet Our Experts" is displayed
    Then Verify picture is displayed
    Then Verify title is displayed
    Then verify quote is displayed
    Then verify social media links is display
    Then verify "facebook" link is functioning
    Then verify "twitter" link is functioning
    Then verify "skype" link is functioning
    Then verify "linkedin" link is functioning

    

    
