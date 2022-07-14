Feature:Feature: Functionality of to interact with employees on the posts.
  Agile story:As a user, I should be able to interact with employees on the posts.

  make a comment,to like a comment,to reply a comment,unfollow other employees's posts

  1.User should be able to make a comment, like, or unfollow other employees' posts.
  2.User should be able to like, or make comments on all other reviewers' comments.
  3.User should be able to like and replay his/her own comment.
  4.After making a comment user should be able to "view comment", "copy link", "edit", "delete" and "create task"
  by clicking more
  5.User should be able to see the reviewers' names and visit their profiles by clicking on reviewers' name
  6.User should be able to add others' posts to favorites by clicking on the Star icon.


  Background: user is on the homepage
    Given user is on the homepage

  @ac1-1
  Scenario: AC1-1 :Verify all users that should be able to make a comment,like or unfollow other employee's posts
    When user clicks comment
    And user types in comment body
    And user click send button
    Then user makes a comment to employee's posts


  @ac1-2
  Scenario: AC1-2 :Verify all users that should be able to make a comment,like or unfollow other employee's posts
    When user clicks like
    Then user likes employee's posts

  @ac1-3
  Scenario: AC1-3 :Verify all users that should be able to make a comment,like or unfollow other employee's posts
    When clicks unfollows
    Then user unfollows employee's posts


  @ac2-1
  Scenario: AC2-1 :Verify all users that should be able to like or make comments on all others reviewers comments
    When clicks view sign
    And user displays reviewers name
    Then user likes reviewers comments


  @ac2-2
  Scenario: AC2-2 :Verify all users that should be able to like or make comments on all others reviewers comments
    When clicks reply
    And user types in comment body
    And user click send button
    Then user makes comments  reviewer's comments



  @ac3-1
  Scenario: AC3-1 :Verify all users that should be able to like and reply his/her comment
    When user clicks like his/her comment
    Then user likes his/her comment


  @ac3-2
  Scenario: AC3-2 :Verify all users that should be able to like and reply his/her comment
    When user  clicks reply
    And user enters text in comment body
    And user clicks send
    Then user replies his/her comment

  @ac4-1
  Scenario: AC4-1 :Verify all users that should be able to "view comment ,copy link,edit,delete and
  create task after making a comment
    When user clicks more
    And  user clicks view comment
    And  user should see alert and accept
    Then user should be able to see  Conversations page


  @ac4-2
  Scenario: AC4-2 :Verify all users that should be able to "view comment ,copy link,edit,delete and
  create task after making a comment
    When user clicks more
    And user clicks copy link
    Then user should be able to  copy link

  @ac4-3
  Scenario: AC4-3 :Verify all users that should be able to "view comment ,copy link,edit,delete and
  create task after making a comment
    When user clicks more
    And user clicks edit
    And user edit comment
    And user clicks send button
    Then user edits employees comment


  @ac4-4
  Scenario: AC4-4 :Verify all users that should be able to "view comment ,copy link,edit,delete and
  create task after making a comment
    When user clicks more
    And user clicks delete
    And user sees alert and click ok
    Then user should be see  delete message

  @ac4-5
  Scenario: AC4-5 :Verify all users that should be able to "view comment ,copy link,edit,delete and
  create task after making a comment
    When user clicks more
    And user clicks create task
    Then user displays task message


  @ac5-1
  Scenario: AC5-1 :Verify all users that should be see reviewers names and
  visit their profiles by clicking on reviewers name
    When user clicks views sign
    Then user sees reviewers names



  @ac5-2
  Scenario: AC5-2 :Verify all users that should be see reviewers names and
  visit their profiles by clicking on reviewers name
    When user clicks views sign
    And user clicks reviewers names
    Then user  visits their profiles


  @ac-6
  Scenario: AC6 :Verify all users that should be able to add other's posts to favorites
  by clicking on the star icon
    When user clicks on the star icon
    Then user adds other's posts to favorites

