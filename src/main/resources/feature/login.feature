Feature: Login feature
  Verify all action in login page

  Scenario: Verify to show error message if input empty in user id
    Given I navigate to login page
    When I input "" into user id text box
    Then I should be to show"User-ID must not be blank"error message

  Scenario: Verify to show error message if input empty text in user id text box 02
    Given I navigate to Login page
    When I enter below info into user id text box
      | {EMPTY} |
    Then I saw error message as below
      | User-ID must not be blank |

  Scenario: Verify to show error message if input empty text in user id text box 03
    Given I navigate to Login page
    When I input below info into user id text box
      | userId  |
      | {EMPTY} |
    Then I see error message as below
      | errorMessage              |
      | User-ID must not be blank |

  Scenario: Verify to show error message if input empty text in user id text box 04
    Given I navigate to Login page
    When I enter <userId> into user id text box
      | userId  |
      | {EMPTY} |
    Then I should be to show <errorMessage> error message
      | errorMessage              |
      | User-ID must not be blank |

  Scenario: Verify to show error message if input empty text in user id text box 04
    Given Adam navigate to Login page
    When Adam enter <userId> into user id text box
      | userId  |
      | {EMPTY} |
    Then Adam should be to show <errorMessage> error message
      | errorMessage              |
      | User-ID must not be blank |

  Scenario Outline: Verify to show error message if input empty text in user id text box 04
    Given I navigate to Login page
    When I input "<userId>" into user id text box
    Then I should be to show "<errorMessage>" error message

    Examples:
      | userId  | errorMessage              |
      | {EMPTY} | User-ID must not be blank |
      | {SPACE} | User-ID must not be blank |