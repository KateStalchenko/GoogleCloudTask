Feature: Calculator Feature

  Background:
    Given User opened Google Cloud Platform Pricing Calculator page

  Scenario: Fulfill form
    When User fulfills Google Cloud Calculator form
    And User adds to estimate
#    Then Estimate form contains equal data as Google Cloud Calculator form