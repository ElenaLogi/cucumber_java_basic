# create 1 scenario outline and create scenario or scenario outlines for page in order to test that user can:
# -add a new person
# -edit a person
# -remove a person
# -reset original list after:
# -adding a person
# -editing a person
# -removing a person
# -check that clear button on adding a user works correctly

Feature: Task2

  Background:
    Given I am on enter people page

  @person
  Scenario Outline: Add a new person
    When I click Add person button
    And I am redirected to add new person page
    And I fill in the form:
      | name     | <name>     |
      | surname  | <surname>  |
      | job      | <job>      |
      | dob      | <dob>      |
      | language | <language> |
      | gender   | <gender>   |
      | status   | <status>   |
    And I click add
    Then I am redirected to home page
    Examples:
      | name  | surname  | job    | dob        | language | gender | status |
      | Elena | Loginova | Tester | 08/02/1986 | english  | female | Intern |

  @edit
  Scenario: Edit a person
    When I click on edit button for second record
    And I see edit form
    And I change name: "Anna"
    And I change surname: "Nikotina"
    And I click edit
    Then I am redirected to home page
    And I see changes for second record

  @remove
  Scenario: remove a person
    When I click on remove button for third record
    Then I see 2 records in the list

  @resetPerson
  Scenario Outline: reset list after adding a person
    When I click Add person button
    And I am redirected to add new person page
    And I fill in the form:
      | name     | <name>     |
      | surname  | <surname>  |
      | job      | <job>      |
      | dob      | <dob>      |
      | language | <language> |
      | gender   | <gender>   |
      | status   | <status>   |
    And I click add
    Then I am redirected to home page
    And I click reset list button at the top
    And I see 3 initial records
    Examples:
      | name   | surname | job | dob        | language | gender | status   |
      | Maksim | Stepan  | QA  | 07/07/1996 | english  | male   | Employee |

  @resetData
  Scenario: reset list after editing a person data
    When I click on edit button for second record
    And I see edit form
    And I change name: "Anna"
    And I change surname: "Nikotina"
    And I click edit
    Then I am redirected to home page
    And I see changes for second record
    And I click reset list button at the top
    And I see initial name and surname for second record

  @resetThirdPerson
  Scenario: reset list after removing the third person
    When I click on remove button for third record
    Then I see 2 records in the list
    And I click reset list button at the top
    And I see 3 initial records

  @clear
  Scenario Outline: check clear fields button when adding new person
    When I click Add person button
    And I am redirected to add new person page
    And I fill in the form:
      | name     | <name>     |
      | surname  | <surname>  |
      | job      | <job>      |
      | dob      | <dob>      |
      | language | <language> |
      | gender   | <gender>   |
      | status   | <status>   |
    And I click clear all fields button
    Then The form is cleared
    Examples:
      | name  | surname  | job    | dob        | language | gender | status |
      | Elena | Loginova | Tester | 08/02/1986 | english  | female | Intern |

  @check
  Scenario: check cancel button on add new person page
    When I click add person bottom button
    And I am redirected to add new person page
    And I click cancel button
    And I am redirected to home page