Feature: Login
  As a user
  I want to log in to the app

  Scenario Outline: User open app first time and tries to login with wrong username/password
    Given App opened for the first time
    Then I see Login screen with username password login button is displayed
    When I enter "<wrongUsername>" and "<wrongPassword>"
    And I click on login button
    Then I see error marks displayed by username and password
    Examples:
      | wrongUsername   | wrongPassword |
      | invalidUsername | test123       |

  @test
  Scenario Outline: User open app first time and tries to login with correct username and password
    Given App opened for the first time
    When I enter "<correctUsername>" and "<correctPassword>"
    And I click on login button
    Then I am taken to the news screen
    Examples:
      | correctUsername | correctPassword |
      | user1           | password        |

  # this scenario has Bug. Login screen opens when app is opened next time after login completed.
  Scenario: User opens the app again after login
    Given App opened after login is completed
    Then I am taken to the news screen