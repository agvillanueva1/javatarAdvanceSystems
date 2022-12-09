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

  @ASJ-14
  Scenario: Footer contact info
    Then Verify footer "Address: 10090 Main St, Fairfax, VA" is displayed
    Then Verify footer "Phone: +1 703-831-3217" is displayed
    Then Verify footer "Email: info@advancesystems.us" is displayed
    Then Verify footer "Mon to Sat: 9.00 am to 5:00 pm" is displayed

  @ASJ-16
  Scenario: Footer social media links
    Then Verify footer social media link "Facebook" is displayed
    And Verify footer social media link "Twitter" is displayed
    And Verify footer social media link "Skype" is displayed
    And Verify footer social media link "LinkedIn" is displayed

  @ASJ-9
  Scenario: Page navigation bar
    Then Verify page navigation bar "Home" is displayed
    And Verify page navigation bar "About Us" is displayed
    And Verify page navigation bar "Services" is displayed
    And Verify page navigation bar "Clients" is displayed
    And Verify page navigation bar "Join Us" is displayed
    And Verify page navigation bar "Contact Us" is displayed