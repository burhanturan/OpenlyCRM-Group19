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

  @burhan
  Scenario Outline:
    When user enters "<username>" and "<password>" and clicks login button
    And user clicks Employees button
    Then user should see Company Structure
    Examples:
      | username                       | password |
      | helpdesk11@cybertekschool.com  | UserUser |
      | hr11@cybertekschool.com        | UserUser |
      | marketing54@cybertekschool.com | UserUser |