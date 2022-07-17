@wipIrfan
Feature: Creating events, by clicking on Event tab, under Activity Stream

#  #OPC-1006
#  US04: As a user, I should be able to create events by clicking on Event tab under Activity Stream.

#  AC1. User should be able to add Event start and ending date and time, select "All day" and specify the time zone.
#  AC2. User should be able to set reminder.
#  AC3. User should be able to select the event location from the dropdown.
#  AC4. User should be able to add members by selecting contacts individually or adding groups and departments.
#  AC5. User should be able to send event by filling the mandatory fields.
#  AC6. User should be able to cancel sending event at any time before sending.


#  Background: User is on the homepage
#    Given user is on the homepage
#    Given user clicks "Event" tab


  # AC1
  Scenario: Verify today's date is default as Event start date and end date
    When user is on the homepage
    And user clicks "Event" tab
    Then user should see today's date in the event start date box
    Then user should see today's date in the event end date box

  Scenario Outline: User should be able to add Event start and ending date and time, select "All day" and specify the time zone
    When user enters Event start date "<Event start date>"
    And user enters Event start time "<Event start time>"
    And user enters Event end date "<Event end date>"
    And user enters Event end time "<Event end time>"
#    Then verify expected time to event start (minutes) "<Event start date>", "<Event start time>", "<expected time to event start (minutes)>"
#    Then verify expected time to event end (minutes) "<Event end date>", "<Event end time>", "<expected time to event end (minutes)>"

    Examples:
#   Values in the table represents figures to be added to current day and hour
#   Event start date = today + value (day)
#   Event start time = current time + value (hour)
      | Event start date | Event start time | Event end date | Event end time | expected time to event start (minutes) | expected time to event end (minutes) |
      | 1                | 1                | 1              | 2              | 1500                                    | 1560                                  |

  Scenario:
    When user clicks All Day check box
    Then user should see the All Day check box is selected
    When user unclicks All Day check box
    Then user should see the All Day check box is NOT selected

  Scenario Outline:
    When user clicks Specify Time Zone link
    And user clicks Time Zone From dropdown menu
    And user should be able to select Time Zone From "<time zone from>"
    And user clicks Time Zone To dropdown menu
    And user should be able to select Time Zone To "<time zone to>"
    Then user should see the expected Time Zone From "<expected time zone from>"
    Then user should see the expected Time Zone To "<expected time zone to>"

    Examples:
      | time zone from               | time zone to                 | expected time zone from      | expected time zone to        |
      | (UTC -05:00) America/Chicago | (UTC -05:00) America/Chicago | (UTC -05:00) America/Chicago | (UTC -05:00) America/Chicago |
#     | (UTC +02:00) Europe/Berlin   | (UTC +02:00) Europe/Berlin   |(UTC +02:00) Europe/Berlin    | (UTC +02:00) Europe/Berlin   |
#     | (UTC +02:00) Europe/Berlin   | (UTC +02:00) Europe/Berlin   |(UTC +02:00) Europe/Berlin    | (UTC +02:00) Europe/Berlin   |
#       425 time zone options available
