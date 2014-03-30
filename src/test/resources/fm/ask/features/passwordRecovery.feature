Feature: Password Recovery

  Background:
    Given Mailbox has no messages

  Scenario: Password recovery
    Given I am on Ask.fm homepage
    When I visit password recovery page
    And I apply for password recovery
    Then I should see password recovery confirmation
    And I should receive an email with password recovery link
    When I open the email and follow the link
    And I enter new password twice
    And I press save new password
    Then I should see password change confirmation
    And I should be able to login with new password