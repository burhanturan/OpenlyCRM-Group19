
Feature:link, insert video, mention, quote, add tag in message.

  User story: As a user, I should be able to add link, insert video, mention, quote, add tag in message.


  Background: user on the homepage
    Given user is on the homepage
  @a
    Scenario:AC-1 : Verify that user should be able to add mentions about only department employees.

      When user clicks the message button on the homepage
      And the user clicks the "Add mention" button
      And the user clicks Department name to open
      And user clicks on employee names to mention departments
      And user clicks on the Send button
      Then user should be able to verify url

  Scenario: AC-2 : Verify that user should be able to attach link to specified text.
    When user clicks on link button
    When user types "google" into text input box
    And user types "https://www.google.com" into link inputbox and clicks save button and then clicks send button
    Then user should see verify google link


