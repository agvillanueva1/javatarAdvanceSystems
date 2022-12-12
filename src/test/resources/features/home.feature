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


  @ASJ-11
  Scenario: Verify 5 items are displayed as headers and description under it
    Then Verify Headers "Leadership Development" is displayed
    Then Verify Headers "Capability Building" is displayed
    Then Verify Headers "Rewards & Benefits" is displayed
    Then Verify Headers "Employee & Employer" is displayed
    Then Verify Headers "Excellent Customer Service" is displayed

  @ASJ-15 @smoke
  Scenario Outline: Links should be able to be displayed and work properly when opened
    When I click link text "<linkText>"
    Then Verify destination window has url as "<URL>"
    Examples:
      | linkText    | URL                                                                 |
      | HOME        | https://tla-batch-6.github.io/advance-systems-test-b6/index.html    |
      | ABOUT US    | https://tla-batch-6.github.io/advance-systems-test-b6/about.html    |
      | SERVICES    | https://tla-batch-6.github.io/advance-systems-test-b6/services.html |
      | CLIENTS     | https://tla-batch-6.github.io/advance-systems-test-b6/clients.html  |
      | JOIN US     | https://tla-batch-6.github.io/advance-systems-test-b6/joinUs.html   |
      | CONTACT US  | https://tla-batch-6.github.io/advance-systems-test-b6/contact.html  |

  @ASJ-9 @smoke
  Scenario Outline: Page navigation bar
    When I click navigation bar "<navBar>"
    Then Verify page navigation bar has url "<titleText>"
    Examples:
      | navBar     | titleText                    |
      | Home       | Advance Systems - Home       |
      | About Us   | Advance Systems - About Us   |
      | Services   | Advance Systems - Services   |
      | Clients    | Advance Systems - Clients    |
      | Join Us    | Advance Systems - Join Us    |
      | Contact Us | Advance Systems - Contact Us |

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

