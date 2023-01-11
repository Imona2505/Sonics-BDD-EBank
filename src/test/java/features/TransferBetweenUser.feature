@regression
Feature: Transfer money between users
  Scenario: User able to transfer money between users
    Given User is on homepage
    When User transfers money between users
    Then User successfully transferred money