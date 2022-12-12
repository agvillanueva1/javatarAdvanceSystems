Feature: Home page tests

  Background: Navigate to Home page
    Given I open url of homepage

  @ASJ-6 @smoke
  Scenario: Test title of the home page
    Then Verify title text is "Advance Systems - Home"

  @ASJ-3 @smoke
  Scenario: Contact info on main page
    Then Verify address "10090 Main Street" is displayed
    Then Verify address "Fairfax, VA, USA" is displayed
    Then Verify phone number "+1 703-831-3217" is displayed

  @ASJ-14 @smoke
  Scenario: Footer contact info
    Then Verify footer "Address: 10090 Main St, Fairfax, VA" is displayed
    Then Verify footer "Phone: +1 703-831-3217" is displayed
    Then Verify footer "Email: info@advancesystems.us" is displayed
    Then Verify footer "Mon to Sat: 9.00 am to 5:00 pm" is displayed

  @ASJ-8 @smoke
  Scenario: Main call to action button
    When I click action button "Join Now"
    Then Verify button takes user to "Join Us" page

  @ASJ-16 @smoke
  Scenario: Footer social media links
    Then Verify footer social media link "Facebook" is displayed
    And Verify footer social media link "Twitter" is displayed
    And Verify footer social media link "Skype" is displayed
    And Verify footer social media link "LinkedIn" is displayed

  @ASJ-9 @smoke
  Scenario Outline: Page navigation bar
    When I click navigation bar "<navBar>"
    Then Verify page navigation bar has url "<URL>"
    Examples:
      | navBar     | URL                                                                 |
      | Home       | https://tla-batch-6.github.io/advance-systems-test-b6/index.html    |
      | About Us   | https://tla-batch-6.github.io/advance-systems-test-b6/about.html    |
      | Services   | https://tla-batch-6.github.io/advance-systems-test-b6/services.html |
      | Clients    | https://tla-batch-6.github.io/advance-systems-test-b6/clients.html  |
      | Join Us    | https://tla-batch-6.github.io/advance-systems-test-b6/joinUs.html   |
      | Contact Us | https://tla-batch-6.github.io/advance-systems-test-b6/contact.html  |

  @ASJ-10
  Scenario Outline: Main social media section
    When I click on social media button "<socialMediaPlatform>"
    Then Verify each button takes user to corresponding page with "<Title>"
    Examples:
      | socialMediaPlatform | Title    |
      | Facebook            | Facebook |
      | Twitter             | Twitter  |
      | Google              | Google   |
      | LinkedIn            | LinkedIn |


  @ASJ-12
  Scenario: Testimonials
    Then Verify header "Words from our Clients" is displayed
    Then Verify description is displayed
    Then Verify client name is displayed
    Then Verify state is displayed