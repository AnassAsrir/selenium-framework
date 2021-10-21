@ui
Feature: Drag and Drop

  Background:
    Given user lands on the The Internet Herokuapp application
    And user opens the "Drag and Drop" page

  Scenario: Drag content A and drop it into B
    Given "column-a" contains letter "A"
    And "column-b" contains letter "B"
    When user drags and drops "column-a" content into "column-b"
    Then "column-a" contains letter "A"
    And "column-b" contains letter "B"