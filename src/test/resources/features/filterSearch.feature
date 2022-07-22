Feature: As a user, I should be able to use "Filter and search" functionality on Active Stream.

  Background: user is on the homepage
    Given user is on the homepage
    When user clicks the filter and search box


  Scenario: User should be able to see default filters as "my activity, work, favorite, announcements, and workflows"
    When user can clicks settings item
    And user clicks the Reset to default message
    And user clicks the continue button
    Then user should be able to see default filters
      | WORKFLOWS     |
      | ANNOUNCEMENTS |
      | MY ACTIVITY   |
      | FAVORITES     |
      | WORK          |


    Scenario: User should be able to add and remove fields.
      When user clicks add file button
      And user should be see the fields
        | Data      |
        | Type      |
        | Author    |
        | To        |
        | Favorites |
        | Tag       |
        | Extranet  |
      Then user should be able to add and remove fields


  Scenario: User should be able to search by specifying the Date
    When user clicks the Restore default fields and can see the default fields
    And user clicks Date line
    And click the Any date or different dates
      | Any date        |
      | Yesterday       |
      | Current day     |
      | This week       |
      | This month      |
      | Current quarter |
      | Last 7 days     |
      | Last 30 days    |
      | Last 60 days    |
      | Last 90 days    |
      | Last N days     |
      | Month           |
      | Quarter         |
      | Year            |
      | Exact date      |
      | Last week       |
      | Last month      |
      | Custom range    |
    Then the user should be able to select on which day wants to choose


    Scenario: User should be able to search by selecting single or multiple types
      When user clicks the Type line
      And user can add more then one Types
      And user click the search button
      Then user can see the added types on the homepage

    Scenario Outline: User should be able to save the filter.
      When user click the SAVE FILTER button
      And give any filter name inside "<Filter Name>"
      And user click the save button.
      Then user can see the saved filter under filters table
      Examples:
        | Filter Name |
        | Services    |

    Scenario: User should be able to restore the default field
      When user clicks the add field button
      And user add some fields
        | Favorites |
        | Tag       |
        | Extranet  |
      And user clicks the Restore default fields button
      Then user should be able to see default page


@byz
    Scenario: User should be able to reset filters to default.
      When user add some Types
        | Appreciations |
        | Announcements |
  And user clicks send button.
      And user clicks filter and search line
      And user clicks the Reset button
      And user clicks filter and search line again
      Then user can see the default page.







