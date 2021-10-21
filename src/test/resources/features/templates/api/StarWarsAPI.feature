@api
Feature: Star Wars API

  Scenario: search for people
    Given I am using resources "people"
    And searching for id 1
    When I send "GET" request
    Then I get response code 200