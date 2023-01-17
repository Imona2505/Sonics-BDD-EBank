@regression
Feature: Transfer Between Accounts
  Scenario: User Successfully Transferred money
    Given User is on the homepages
    When  User Transferred money
    Then  User gets success message
    When  Admin approves transaction
