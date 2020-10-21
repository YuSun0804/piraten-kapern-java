@tag
Feature: Test features for Level 1b-skull
  I want to use this to scenario in level 1b-skull


  @Test100101
  Scenario Outline: Test97100101
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | test      | fortuneCard | rollResult                                                                     | score |
      | "Test100" | "two_skull" | "0=skull, 1=monkey, 2=parrot, 3=coin, 4=coin, 5=diamond, 6=diamond, 7=diamond" | 0     |
      | "Test101" | "one_skull" | "0=skull, 1=skull, 2=parrot, 3=coin, 4=coin, 5=diamond, 6=diamond, 7=diamond"  | 0     |

  @Test102
  Scenario Outline: Test102
    Given Start test
    When Draw fortuneCard, and get <fortuneCard>
    When Roll dice, and get <rollResult>
    Then Player make <deduction> deduction to all other players
    Examples:
      | fortuneCard | rollResult                                                                   | deduction |
      | "captain"   | "0=skull, 1=skull, 2=skull, 3=skull, 4=skull, 5=monkey, 6=monkey, 7=diamond" | -1000     |

  @Test103105
  Scenario Outline: Test103105
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player make <deduction> deduction to all other players
    Examples:
      | test      | fortuneCard | rollResult                                                                    | reRollIndexes | reRollResult        | reRollIndexes2 | reRollResult2        | deduction |
      | "Test103" | "two_skull" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=parrot, 5=parrot, 6=coin, 7=diamond" | "2,3"         | "2=skull, 3=skull"  | "4,5"          | "4=skull, 5=monkey"  | -700      |
      | "Test105" | "one_skull" | "0=skull, 1=skull, 2=skull, 3=monkey, 4=parrot, 5=parrot, 6=coin, 7=parrot"   | "3,4"         | "3=skull, 4=monkey" | "4,5"          | "4=monkey, 5=monkey" | -500      |

  @Test104
  Scenario Outline: Test104
    Given Start test
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player make <deduction> deduction to all other players
    Examples:
      | fortuneCard | rollResult                                                                   | reRollIndexes | reRollResult         | deduction |
      | "two_skull" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=skull, 5=parrot, 6=coin, 7=diamond" | "2,3"         | "2=monkey, 3=monkey" | -500      |
