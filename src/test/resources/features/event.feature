Feature: Creating events, by clicking on Event tab, under Activity Stream

  US04: As a user, I should be able to create   events by clicking on Event tab under Activity Stream.

  AC1. User should be able to add Event start and ending date and time, select "All day" and specify the time zone.
  AC2. User should be able to set reminder.
  AC3. User should be able to select the event location from the dropdown.
  AC4. User should be able to add members by selecting contacts individually or adding groups and departments.
  AC5. User should be able to send event by filling the mandatory fields.
  AC6. User should be able to cancel sending event at any time before sending.

  Background: User is on the homepage
    Given user is on the homepage
    Given user clicks "Event" tab

    #AC1: User should be able to add Event start and ending date and time, select "All day" and specify the time zone.


    #OPC-xxx: Verify today's date is default as Event start date and end date
  Scenario: Verify today's date is default as Event start date and end date
    Then user should see today's date in the event start date box
    Then user should see today's date in the event end date box

  @wipIrfan
    #OPC-xxx: Verify user is able to add Event start and ending date and time (Positive Scenario)
  Scenario: Verify user is able to add Event start and ending date and time (Positive Scenario)
    When user enters Event Start Date
    And user enters Event Start Time
    And user enters Event End Date
    And user enters Event End Time

  Scenario: Verify user is able to select "All Day"
    When user clicks All Day check box
    Then user should see the All Day check box is selected
    And user unclicks All Day check box
    Then user should see the All Day check box is NOT selected