@ui
Feature: Dropdown

  Background:
    Given user lands on the The Internet Herokuapp application
    And user opens the "Dropdown" page

  Scenario: Select an option
    Given initially that no option is selected
    When user selects option 1
    Then option 1 is selected