Feature: Groups

  Scenario Outline: Create new group
    Given a set of groups
    When I create a new group with <name> and <header> and <footer>
    Then the new set of groups is equal to the old set with added group

  Examples:
    | name      | header      | footer      |
    | test name | test header | test footer |