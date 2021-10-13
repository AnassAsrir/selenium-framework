@ui
Feature: Broken Images

  Background:
    Given user lands on the The Internet Herokuapp application
    And user opens the "Broken Images" page

  Scenario Outline: Check that image <imageIndex> is not broken
    When image <imageIndex>
    Then if broken test should fail
    Examples:
      | imageIndex |
      | 2          |
      | 3          |
      | 4          |