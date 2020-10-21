@tag
Feature: Test features for Level 1b-sea battle
  I want to use this to scenario in level 1b-sea battle

  @Test109-111
  Scenario Outline: Test109-111
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player lose <deduction>
    Examples:
      | test      | fortuneCard   | rollResult                                                                  | deduction |
      | "Test109" | "two_sabre"   | "0=skull, 1=skull, 2=skull, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword" | -300      |
      | "Test110" | "three_sabre" | "0=skull, 1=skull, 2=skull, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword" | -500      |
      | "Test111" | "four_sabre"  | "0=skull, 1=skull, 2=skull, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword" | -1000     |

  @Test113116119
  Scenario Outline: Test113116119
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | test      | fortuneCard   | rollResult                                                                   | score |
      | "Test103" | "two_sabre"   | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=coin, 6=parrot, 7=parrot" | 500   |
      | "Test116" | "three_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=sword, 7=parrot" | 800   |
      | "Test119" | "four_sabre"  | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=sword, 7=skull"  | 1300  |


  @Test114117
  Scenario Outline: Test114117
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | test      | fortuneCard   | rollResult                                                                     | reRollIndexes | reRollResult                         | score |
      | "Test114" | "two_sabre"   | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=sword, 5=skull, 6=parrot, 7=parrot" | "6,7"         | "6=skull, 7=sword"                   | 500   |
      | "Test117" | "three_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=sword, 5=sword, 6=skull, 7=skull"   | "0,1,2,3"     | "0=skull, 1=skull, 2=sword, 3=sword" | 0     |

  @Test120
  Scenario Outline: Test120
    Given Start test
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard  | rollResult                                                                      | reRollIndexes | reRollResult       | reRollIndexes2 | reRollResult2                 | score |
      | "four_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=skull, 5=diamond, 6=parrot, 7=parrot" | "6,7"         | "6=sword, 7=sword" | "0,1,2"        | "0=sword, 1=parrot, 2=parrot" | 1300  |