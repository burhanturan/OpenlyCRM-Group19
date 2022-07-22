Feature: As a user, I should be able to assign tasks under Quick Navigate Menu.

  Background: user is on the homepage
    Given user is on the homepage

    Scenario:
      When user click on Task button
      And user click High priority checkbox
      And user fill Things To Do inbox
      And user click Send button.
      And user click task created popup
      Then user see task created with high priority

      Scenario:
        When user click on Task button
        And user  click on responsible person-add more button
        And user select two more users
        And user fill Things To Do inbox
        And user click Send button.
        And user click task created popup
        Then user see task is created with two responsible users

#negative scenario
  Scenario:
    When user click on Task button
    And user  click on responsible person-add more button
    And user select four more users
    And user fill Things To Do inbox
    And user click Send button.
    Then user see task is not created

  Scenario:
    When user click on Task button
    And user read ongoing task counter
    And user fill Things To Do inbox
    And user click Send button.
    Then user see it counted on the My Tasks table

  Scenario:
    When user click on Task button
    And user fill Things To Do inbox
    And user click checklist button
    And user fill inbox and click tick
    And user click Send button.
    And user click task created popup
    Then user see task created with checklist items

  Scenario Outline:
    When user click on Task button
    And user fill Things To Do inbox
    And user click Deadline inbox
    And user select "<month>", "<year>", "<day>", "<hour>", "<minute>" and "<am_pm>"
    And user click Send button.
    And user click task created popup
    Then user see the selected deadline as "<date_time>"
    Examples:
      | month     | year | day | hour | minute | am_pm | date_time           |
      | August    | 2022 | 12  | 07   | 30     | PM    | 08/12/2022 07:30 pm |
      | September | 2023 | 05  | 11   | 00     | AM    | 09/05/2023 11:00 am |
      | November  | 2022 | 30  | 06   | 00     | PM    | 11/30/2020 06:00 pm  |
#negative scenario
  @jas
  Scenario Outline:
    When user click on Task button
    And user fill Things To Do inbox
    And user click Deadline inbox
    And user select "<month>", "<year>", "<day>", "<hour>", "<minute>" and "<am_pm>"
    And user click Send button.
    Then user see task is not created
    Examples:
      | month     | year | day | hour | minute | am_pm |
      | September | 2020 | 30  | 06   | 00     | PM    |


  Scenario Outline:
    When user click on Task button
    And user fill Things To Do inbox
    And user click Time planning button
    And user fill Start task on inbox
    And user select "<month>", "<year>", "<day>", "<hour>", "<minute>" and "<am_pm>"
    And user fill Duration inbox
    And user click Send button.
    And user click task created popup
    Then user see the selected "<startDate>" and "<endDate>"
    Examples:
      | month  | year | day | hour | minute | am_pm | startDate           | endDate             |
      | August | 2022 | 10  | 07   | 30     | PM    | 08/10/2022 07:30 pm | 08/20/2022 07:30 pm |