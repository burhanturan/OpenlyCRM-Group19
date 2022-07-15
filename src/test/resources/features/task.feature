Feature: As a user, I should be able to assign tasks under Quick Navigate Menu.

  Background: user is on the homepage
    Given user is on the homepage
    @jas
    Scenario:
      When user click on Task button
      And user click High priority checkbox
      And user fill Things To Do inbox
      And user click Send button.
      Then user see task created with high priority

