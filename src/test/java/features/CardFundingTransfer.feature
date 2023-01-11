@regression
Feature: Card Funding Transfer
  Scenario: User should be able to transfer between the cards
    Given User is on the homepage
    When User tries to transfer between cards
    Then User should successfully transfer