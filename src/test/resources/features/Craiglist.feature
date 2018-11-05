@all
Feature: Craiglist Page Testing

  Background:
    Given open craiglist webpage
    Given select language English

  Scenario: Open Housing page and check default sorting. Also check High and Low price sorting.
    Then check filters in dropdown
    And check High price sorting
    Then check Lowest price sorting

  Scenario: Make Search and check sorting possibilities
    Then add predefined text in search field
    And check dropdown sorting after search

  Scenario: Failure test to see Reporting with Failure screenshot
    And check Lowest price sorting