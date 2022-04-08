    # TODO
    # Scenario outline for error cases:
    # -enter number too small
    # -enter number too big
    # -enter text instead of the number
    # Scenario for correct number:

    Feature: task1

      Background:
        Given I am on the page

      @invalid
      Scenario Outline: for error cases
        When I enter number "<number>" in the field
        And I click submit button
        Then I see error message: "<error>"
        Examples:
          | number | error                 |
          | 20     | Number is too small   |
          | 150    | Number is too big     |
          | num    | Please enter a number |

      @valid
      Scenario Outline: for correct number
        When I enter number "<number>" in the field
        And I click submit button
        Then I see alert message: "<result>"
        Examples:
          | number |
          | 60     |


