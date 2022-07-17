@OPC-1115
Feature: Default

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1103
	Scenario Outline: Verify that all user types should be able to display company structure
		When user enters "<username>" and "<password>" and clicks login button
		    And user clicks Employees button
		    Then user should see Company Structure
		    Examples:
		      | username                       | password |
		      | helpdesk11@cybertekschool.com  | UserUser |
		      | hr11@cybertekschool.com        | UserUser |
		      | marketing54@cybertekschool.com | UserUser |	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1104
	Scenario: Verify that Hr user should be able to add a department from the company structure
		Given user is on the homepage
		    When user clicks Employees button
		    And user clicks Add Department button
		    And enters department name "Group-191" and clicks and button
		    Then user should see the department in Company Structure	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1105
	Scenario: Verify that Hr user should be able to select a parent department from the department dropdown
		Given user is on the homepage
		    When user clicks Employees button
		    And user clicks Add Department button
		    Then user should be able to select from department dropdown	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1106
	Scenario: Verify that Hr user should be able to select a supervisor from "recent"
		Given user is on the homepage
		    When user clicks Employees button
		    And user clicks Add Department button
		    And user clicks select from structure link and clicks employee as a supervisor
		    Then user should see the employee is selected	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1107
	Scenario: Verify that Hr user should be able to select a supervisor from "company"
		Given user is on the homepage
		    When user clicks Employees button
		    And user clicks Add Department button
		    And user clicks select from structure link ,company button and clicks one of the employee as a supervisor
		    Then user should see the employee is selected	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1108
	Scenario: Verify that Hr user should be able to select a supervisor from "search"
		Given user is on the homepage
		    When user clicks Employees button
		    And user clicks Add Department button
		    And user clicks select from structure link ,search button and search for an employee to click
		    Then user should see the employee is selected	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1109
	Scenario: Verify that Hr user should be able to close add department pop-up at any time before sending.
		Given user is on the homepage
		    When user clicks Employees button
		    And user clicks Add Department button
		    And enters department name "Group-192"
		    And user clicks close button before send
		    Then user should be able to close add department pop-up at any time before sending	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1110
	Scenario: Verify that Hr user should be able to edit departments
		Given user is on the homepage
		    When user clicks Employees button
		    And user clicks edit button and changes department name "Cydeo"
		    Then user should be able to edit department	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1111
	Scenario: Verify that Hr user should be able to add child departments
		Given user is on the homepage
		    When user clicks Employees button
		    And user clicks add child button
		    And enters department name "Group-193" and clicks and button
		    Then user should be able to add child department	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1112
	Scenario: Verify that Hr user should be able to delete departments
		Given user is on the homepage
		    When user clicks Employees button
		    And user clicks delete button
		    Then user should be able to delete department	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1113
	Scenario: Verify that Hr user should be able to drag and drop the existing department under another department as a subdepartment.
		Given user is on the homepage
		    When user clicks Employees button
		    And user drags and drops a department under another department as a subdepartment
		    Then user should be able to drags and drops a department under another department as a subdepartment	

	#*User Story:*
	#
	#As a user, I should be able to use functions on Company Structure under Employee menu.
	#
	#*AC 1:*
	#
	#All user types should be able to display company structure.
	@OPC-1114
	Scenario Outline: Verify that helpdesk and marketing users can not change company structure.
		When user enters "<username>" and "<password>" and clicks login button
		    And user clicks Employees button
		    Then user should not be able to see edit,delete and add button
		    And user should not be able to drag and drop departments as a subdepartment
		    Examples:
		      | username                       | password |
		      | helpdesk11@cybertekschool.com  | UserUser |
		      | marketing54@cybertekschool.com | UserUser |