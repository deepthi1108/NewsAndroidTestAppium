Feature: News
  As a user
  I want to see my news

  Scenario: Verify news images are loaded
    Given User successfully logged in to the app and "internet" connection
    Then I see images displayed in the rows on the list and scrollable horizontally

  Scenario: Verify news image is clicked
    Given User successfully logged in to the app and "internet" connection
    And News images are successfully loaded on the screen
    When I click on the news image
    Then I am navigated to the external browser with clicked image loaded

  # this scenario has bug. There is no retry button displayed when there is no internet connection. only error message is displayed
  Scenario: Images failed to load error
    Given User successfully logged in to the app and "no internet" connection
    And I see failed lo load news error message displayed with retry button



