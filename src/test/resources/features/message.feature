
Feature:link, insert video, mention, quote, add tag in message.

  User story: As a user, I should be able to add link, insert video, mention, quote, add tag in message.


  Background: user on the homepage
    Given user is on the homepage
  @a
    Scenario:AC-1 User should be able to add mentions about only department employees.

      When user clicks the message button on the homepage
      And the user clicks the "Add mention" button
      And the user clicks Department name to open
      And user clicks on employee names to mention departments
      And user clicks on the Send button
      Then user should be able to verify url


