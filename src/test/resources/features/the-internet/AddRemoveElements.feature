@ui
  Feature: Add/Remove Elements
    This test suite verifies that buttons "Add Element" and "Delete" elements work as expected

    Background:
      Given user lands on the The Internet Herokuapp application
      And user opens the "Add/Remove Elements" page

    Scenario: Add one element
      When user clicks once the button Add Element
      Then one new element is added on the page