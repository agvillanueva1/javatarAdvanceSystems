Feature: Home page tests

  Background: Navigate to Home page
    Given I open url of homepage

  @ASJ-6 @smoke
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
    And Verify footer social media link "Instagram" is displayed
    And Verify footer social media link "LinkedIn" is displayed


  @ASJ-11 @smoke
  Scenario: Verify 5 items are displayed as headers and description under it
    Then Verify Headers "Leadership Development" is displayed
    Then Verify Headers "Capability Building" is displayed
    Then Verify Headers "Rewards & Benefits" is displayed
    Then Verify Headers "Employee & Employer Relations" is displayed
    Then Verify Headers "Excellent Customer Service" is displayed
    Then Verify description "Lorem Ipsum is simply dummy text of the printing and typesetting industry." is displayed

  @ASJ-15 @smoke
  Scenario Outline: Links should be able to be displayed and work properly when opened
    When I click link text "<linkText>"
    Then Verify destination window has url as "<URL>"
    Examples:
      | linkText   | URL                                                                 |
      | HOME       | https://tla-batch-6.github.io/advance-systems-test-b6/index.html    |
      | ABOUT US   | https://tla-batch-6.github.io/advance-systems-test-b6/about.html    |
      | SERVICES   | https://tla-batch-6.github.io/advance-systems-test-b6/services.html |
      | CLIENTS    | https://tla-batch-6.github.io/advance-systems-test-b6/clients.html  |
      | JOIN US    | https://tla-batch-6.github.io/advance-systems-test-b6/joinUs.html   |
      | CONTACT US | https://tla-batch-6.github.io/advance-systems-test-b6/contact.html  |

  @ASJ-9 @smoke
  Scenario Outline: Page navigation bar
    When I click navigation bar "<navBar>"
    Then Verify page navigation bar has correct title "<titleText>"
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
      | socialMediaPlatform | Title     |
      | Facebook            | Facebook  |
      | Twitter             | Twitter   |
      | Instagram           | Instagram |
      | LinkedIn            | LinkedIn  |

  @ASJ-13 @smoke @regression
  Scenario: List of companies
    Then Verify that companies name displayed in one row

  @ASJ-7 @smoke @regression
  Scenario: General navigation bar
    Then Verify navigation bar button "Get Support" is displayed
    Then Verify navigation bar button "Job Career" is displayed
    Then Verify navigation bar button "Feedback" is displayed
    When I click a language selection button
    Then Verify navigation bar button "English" is displayed
    Then Verify navigation bar button "Spanish" is displayed
    Then Verify navigation bar button "French" is displayed

  @ASJ-012
  Scenario: Testimonials
    Then Verify header "Words from our Clients" is displayed
    Then Verify "message" is displayed
    Then Verify "name" is displayed
    Then Verify "state" is displayed

  @ASJ-17
  Scenario: Newsletter section
    Then Verify newsletter placeholder "Email Address..." is displayed

  @ASJ-18
  Scenario: Move to top button
    Then Verify a button "scroll to top" is enabled

  @ASJ-19 @smoke
  Scenario: Copyright update
    Then Verify footer "Copyright © 2022 Advance Systems LLC. All Rights Reserved." is displayed

  @ASJ-20 @smoke
  Scenario Outline: Main Header section
    Then Verify header text "<headerTxt>" is displayed
    Examples:
      | headerTxt                                                                          |
      | Welcome to Advance Systems LLC                                                     |
      | Our Mission is simple, deliver very honest recruitment services to every customer  |
      | Day in and day out for the last years we’ve been more than just a staffing company |

    @ASJ-29
    Scenario: About Us page Main Content
      Then I click on navBar "About Us"
      Then Verify About Us header "Welcome to Advance Systems LLC." is displayed
      Then verify section contain "name" and "title" of the person




