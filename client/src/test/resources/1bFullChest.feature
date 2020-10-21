@tag
Feature: Test features for Level 1b-fullchest
  I want to use this to scenario in level 1b-fullchest

  @Test91-93
  Scenario Outline: Test91-93
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | test     | fortuneCard | rollResult                                                                     | score |
      | "Test91" | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=diamond, 7=parrot" | 400   |
      | "Test92" | "captain"   | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=coin, 7=coin"      | 1800  |
      | "Test93" | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=sword, 7=diamond"  | 1000  |

  @Test94
  Scenario Outline: Test94
    Given Start test
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                    | reRollIndexes | reRollResult      | score |
      | "two_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=sword, 5=parrot, 6=parrot, 7=coin" | "5,6"         | "5=coin, 6=sword" | 1200  |

  @Test97
  Scenario Outline: Test97
    Given Start test
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard       | rollResult                                                                      | score |
      | "monkey_business" | "0=monkey, 1=monkey, 2=parrot, 3=coin, 4=coin, 5=diamond, 6=diamond, 7=diamond" | 1200  |