@burhan2
Feature: Testing department functionality
  As a user, I should be able to use functions on
  Company Structure under Employee menu.

  1. All user types should be able to display company structure.
  2. Hr user should be able to add a department from the company structure.
  3. Hr user should be able to select a parent department from the department dropdown.
  4.Hr user should be able to select a supervisor from "recent", "company" and "search"
  5.Hr user should be able to close add department pop-up at any time before sending.
  6.Hr user should be able to edit departments, add child departments, and delete departments after adding the department.
  7.Hr user should be able to drag and drop the existing department under another department as a subdepartment.
  8. Helpdesk and marketing users can not change company structure.

  ## AC 1
  Scenario Outline: Verify that all user types should be able to display company structure.
    When user enters "<username>" and "<password>" and clicks login button
    And user clicks Employees button
    Then user should see Company Structure
    Examples:
      | username                       | password |
      | helpdesk11@cybertekschool.com  | UserUser |
      | hr11@cybertekschool.com        | UserUser |
      | marketing54@cybertekschool.com | UserUser |

  ## AC 2
  Scenario: Verify that Hr user should be able to add a department from the company structure.
    Given user is on the homepage
    When user clicks Employees button
    And user clicks Add Department button
    And enters department name "Group-19" and clicks and button
    Then user should see the department in Company Structure
  ## AC 3
  Scenario: Verify that Hr user should be able to select a parent department from the department dropdown.
    Given user is on the homepage
    When user clicks Employees button
    And user clicks Add Department button
    Then user should be able to select from department dropdown

  ## AC 4-1
  Scenario: Verify that Hr user should be able to select a supervisor from "recent"
    Given user is on the homepage
    When user clicks Employees button
    And user clicks Add Department button
    And user clicks select from structure link and clicks employee as a supervisor
    Then user should see the employee is selected

  ## AC 4-2
  Scenario: Verify that Hr user should be able to select a supervisor from "company"
    Given user is on the homepage
    When user clicks Employees button
    And user clicks Add Department button
    And user clicks select from structure link ,company button and clicks one of the employee as a supervisor
    Then user should see the employee is selected

  ## AC 4-3
  Scenario: Verify that Hr user should be able to select a supervisor from "search"
    Given user is on the homepage
    When user clicks Employees button
    And user clicks Add Department button
    And user clicks select from structure link ,search button and search for an employee to click
    Then user should see the employee is selected
   ## AC 5
  @burhan
  Scenario: Verify that Hr user should be able to close add department pop-up at any time before sending.
    Given user is on the homepage
    When user clicks Employees button
    And user clicks Add Department button
    And enters department name "Group-19"
    And user clicks close button before send
    Then user should be able to close add department pop-up at any time before sending
