Feature: Example Scenario

  @ui
  Scenario: Negative login check
    When I login to portal with following credentials:
      |UserName  |WrongUserName |
      |Password  |WrongPassword |
    Then The error message displayed on Login Page

  @api
  Scenario: Fake api test
    Then The todo with id "1" has title "delectus aut autem"
