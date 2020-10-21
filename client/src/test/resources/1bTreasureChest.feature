@tag
Feature: Test features for Level 1b-treasureChest
  I want to use this to scenario in level 1b-treasureChest

  @Test80
  Scenario Outline: Test80
    Given Start test
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And put <inChest> in chest
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And put <inChest2> in chest, take <outChest2> out
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard      | rollResult                                                                     | inChest | reRollIndexes | reRollResult         | inChest2    | outChest2 | reRollIndexes2 | reRollResult2               | score |
      | "treasure_chest" | "0=parrot, 1=parrot, 2=parrot, 3=sword, 4=sword, 5=diamond, 6=diamond, 7=coin" | "5,6,7" | "3,4"         | "3=parrot, 4=parrot" | "0,1,2,3,4" | "5,6,7"   | "5,6,7"        | "5=skull, 6=parrot, 7=coin" | 1100  |

  @Test85
  Scenario Outline: Test85
    Given Start test
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And put <inChest> in chest
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And put <inChest2> in chest
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard      | rollResult                                                               | inChest | reRollIndexes | reRollResult                   | inChest2 | reRollIndexes2 | reRollResult2     | score |
      | "treasure_chest" | "0=skull, 1=skull, 2=parrot, 3=parrot, 4=parrot, 5=coin, 6=coin, 7=coin" | "5,6,7" | "2,3,4"       | "2=diamond, 3=diamond, 4=coin" | "4"      | "2,3"          | "2=skull, 3=coin" | 600   |
