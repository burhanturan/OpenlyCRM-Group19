@wipIrfan
Feature: Creating events, by clicking on Event tab, under Activity Stream

#  OPC-1006
#  US04: As a user, I should be able to create events by clicking on Event tab under Activity Stream.

#  AC1. User should be able to add Event start and ending date and time, select "All day" and specify the time zone.
#  AC2. User should be able to set reminder.
#  AC3. User should be able to select the event location from the dropdown.
#  AC4. User should be able to add members by selecting contacts individually or adding groups and departments.
#  AC5. User should be able to send event by filling the mandatory fields.
#  AC6. User should be able to cancel sending event at any time before sending.


# OPC-1086 Pre-condition
  Background: User is on the homepage
    Given user is on the homepage
    Given user clicks "Event" tab


  # AC1
  # OPC-1085
  Scenario: Verify today's date is default as Event start date and end date
    Then user should see today's date in the event start date box
    Then user should see today's date in the event end date box

  # OPC-1087
  Scenario Outline: User should be able to add Event start and ending date and time
    When user enters Event start date "<Event start date>"
    And user enters Event start time "<Event start time>"
    And user enters Event end date "<Event end date>"
    And user enters Event end time "<Event end time>"
    Then user should see Event start date & time, end date & time "<Event start date>", "<Event start time>", "<Event end date>", "<Event end time>"

    Examples:
#   Values in the table represents figures to be added to current day and hour
#   Event start date = today + value (day)
#   Event start time = current time + value (hour)
      | Event start date | Event start time | Event end date | Event end time |
      | 1                | 1                | 1              | 2              |

  # OPC-1116
  Scenario: User should be able to select "All day" and specify the time zone
    When user clicks All Day check box
    Then user should see the All Day check box is selected
    When user unclicks All Day check box
    Then user should see the All Day check box is NOT selected

  # OPC-1117
  Scenario Outline: User should be able to specify Time Zone
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
#       425 time zone options available in a dropbox


  # AC2
  # OPC-1118
  Scenario: User should be able to set reminder

    Given Event set reminder checkbox is checked
    When user clicks Event set reminder checkbox
    Then user should see set reminder checkbox is unchecked
    When user clicks Event set reminder checkbox
    Then user should see set reminder checkbox is checked

    Given user should see Event reminder count "15" by default
    When user enters "5" into Event reminder count input box
    Then user should see "5" in the Event reminder count input box

    Given user should see Event reminder type "minutes" by default
    When user clicks Event remind type dropdown menu
    And user should see below info in event remind type dropdown
      | minutes |
      | hours   |
      | days    |

    And user selects "minutes" in the event remind type dropdown menu
    Then user should see the "minutes" in the event remind type box


  # AC3
  # OPC-1119
  Scenario: User should be able to select the event location from the dropdown
    Given User should see select meeting room as placeholder in the Event location dropdown input box
    When user clicks Event location dropdown
    Then user should see below info in Event location dropdown
      | Central Meeting Room |
      | East Meeting Room    |
      | West Meeting Room    |

    And user selects "Central Meeting Room" in the Event location dropdown
    Then user should see the expected Event location "Central Meeting Room"


  # AC4
  # OPC-1120
  Scenario: User should be able to add members by selecting contacts individually or adding groups and departments
    When user clicks Members input box
    And user clicks Employees And Departments link
    And user clicks "HR1" department
    And user clicks All department and subdepartment employees checkbox under "HR1"
    And user selects following contacts
      | marketing54@cybertekschool.com |
      | hr11@cybertekschool.com        |
      | helpdesk11@cybertekschool.com  |
    Then user should see the selected departments and contacts in the Members input box
      | HR1                            |
      | marketing54@cybertekschool.com |
      | hr11@cybertekschool.com        |
      | helpdesk11@cybertekschool.com  |


  # AC5
  # OPC-1121
  Scenario: User should NOT be able to send event without filling the mandatory field - Event name
    When Event name input box is empty
    Then Verify that Event Send button is NOT clickable

  # OPC-1122
  Scenario: User should be able to send event by filling the mandatory fields
    When user enters Event name "Cydeo Meeting 1" in the Event name input box
    And user clicks on the Event Send button
    Then user should see the created event with name "Cydeo Meeting 1" in the Activity Stream at the current time


  # AC6
  # OPC-1123
  Scenario: User should be able to cancel sending event at any time before sending
    When user clicks Cancel button
    Then user should be able to see homepage

