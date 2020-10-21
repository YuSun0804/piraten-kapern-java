@tag
Feature: Test features for Level 1b-monkey
  I want to use this to scenario in level 1b-monkey

  @Test75
  Scenario Outline: Test75
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | test     | fortuneCard       | rollResult                                                                    | score |
      | "Test75" | "monkey_business" | "0=skull, 1=parrot, 2=parrot, 3=parrot, 4=monkey, 5=monkey, 6=monkey, 7=coin" | 1100  |

  @Test7677
  Scenario Outline: Test7677
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | test     | fortuneCard       | rollResult                                                                    | reRollIndexes | reRollResult                  | reRollIndexes2 | reRollResult2       | score |
      | "Test76" | "monkey_business" | "0=monkey, 1=monkey, 2=parrot, 3=coin, 4=coin, 5=sword, 6=sword, 7=sword"     | "5,6,7"       | "5=diamond, 6=sword, 7=sword" | "6,7"          | "6=sword, 7=sword"  | 400   |
      | "Test77" | "monkey_business" | "0=monkey, 1=monkey, 2=monkey, 3=parrot, 4=parrot, 5=sword, 6=sword, 7=sword" | "5,6,7"       | "5=parrot, 6=sword, 7=sword"  | "6,7"          | "6=parrot, 7=sword" | 2000  |