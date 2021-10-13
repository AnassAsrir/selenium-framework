@ui @test
  Feature: Add Remove Elements
    This test suite verifies that buttons "Add Element" and "Delete" elements work as expected

    Background:
      Given user lands on the The Internet Herokuapp application
      And user opens the "Add/Remove Elements" page

    Scenario: Add one element
      When user clicks once the button Add Element
      Then one new element is added on the page

    Scenario: Add multiple elements
      When user clicks multiple times the button Add Element
      Then multiple elements are added on the page

    Scenario: Remove an element
      When user clicks multiple times the button Add Element
      When user deletes one element
      Then only one element is deleted

    Scenario: Remove multiple elements
      When user clicks multiple times the button Add Element
      When user deletes all elements
      Then all elements are deleted