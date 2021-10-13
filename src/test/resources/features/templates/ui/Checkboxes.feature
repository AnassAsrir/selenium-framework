@ui
Feature: Checkboxes

  Background:
    Given user lands on the The Internet Herokuapp application
    And user opens the "Checkboxes" page

  Scenario: Check a box
    When user checks box 1
    Then checkbox 1 is checked