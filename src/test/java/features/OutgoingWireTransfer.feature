@regression
Feature: Outgoing Wire Transfer
  Scenario: User successfully transfers money
    Given User is on the homepages
    When User transfers money
    Then User successfully transfer money
    When Admin approves the transaction