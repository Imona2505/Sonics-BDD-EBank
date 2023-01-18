@regression
Feature: Opening Homepage
  Scenario: User has access to homepage
    Given User is on the homepages
    When User logs in
    Then Verify the Log out button