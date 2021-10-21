@ui
Feature: Authentication form
  As a user I want to test authentication service

  Background:
    Given user lands on the The Internet Herokuapp application
    And user opens the "Form Authentication" page

  @happy-path
  Scenario Outline: Authenticate using correct login and password
    When I type "<login>" and "<password>"
    And I click login button
    Then the "<login-message>" should be displayed
    Examples:
      | title          | login | password             | login-message             |
      | wrong username | tomsmith  | SuperSecretPassword! | You logged into a secure area! |


  @sad-path
  Scenario Template: Authenticate using <title>
    When I type "<login>" and "<password>"
    And I click login button
    Then the "<login-message>" should be displayed
    Examples:
      | title          | login    | password             | login-message             |
      | wrong username | toto     | SuperSecretPassword! | Your username is invalid! |
      | wrong password | tomsmith | S                    | Your password is invalid! |

  @excel @test
  Scenario: Authenticate using data from external file
    When I type loaded login data from external file
    And I click login button
    Then the "login-message" should be displayed