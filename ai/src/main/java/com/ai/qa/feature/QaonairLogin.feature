#Author: SLTP
Feature: Login to Qaonair

  #DataTable for user login
  @Login
  Scenario: Login with credentials
    Given User logged in to system and clicks on add activity
    When User enter activity details
    And User click on publish button
    Then Activity added and displayed in myactivities list
 