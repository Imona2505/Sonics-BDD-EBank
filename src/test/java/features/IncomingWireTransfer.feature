@regression
Feature: Incoming Wire Transfer
  Scenario: Incoming Wire Transfer
    Given User is logs in
    When User makes an incoming wire transfer
    Then User gets the verify message