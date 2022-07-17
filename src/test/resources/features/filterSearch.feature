Feature: As a user, I should be able to use "Filter and search" functionality on Active Stream.

  Background: user is on the homepage
    Given user is on the homepage
    When user clicks the filter and search box

@byz
  Scenario: User should be able to see default filters as "my activity, work, favorite, announcements, and workflows"
    When user can clicks settings item
    And user clicks the Reset to default message
    And user clicks the continue button
    Then user should be able to see default filters
      | WORKFLOWS     |
      | ANNOUNCEMENTS |
      | MY ACTIVITY   |
      |FAVORITES      |
      |WORK           |

