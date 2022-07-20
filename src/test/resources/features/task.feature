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
  @jas
  Scenario:
    When user click on Task button
    And user  click on responsible person-add more button
    And user select four more users
    And user fill Things To Do inbox
    And user click Send button.
    Then user see task is not created


