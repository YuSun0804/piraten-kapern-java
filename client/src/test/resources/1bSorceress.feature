@tag
Feature: Test features for Level 1b-sorceress
  I want to use this to scenario in level 1b-sorceress

  @Test70
  Scenario Outline: Test70
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes> due to sorceress, and get <reRollResult>
    Then Player get <skullCount> skull(s)
    And Player can go to next round <can>
    Examples:
      | test     | fortuneCard | rollResult                                                                     | reRollIndexes | reRollResult         | skullCount | can  |
      | "Test70" | "sorceress" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=monkey, 5=diamond, 6=diamond, 7=coin" | "1,2"         | "1=monkey, 2=parrot" | 1          | true |

  @Test71
  Scenario Outline: Test71
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2> due to sorceress, and get <reRollResult2>
    Then Player get <skullCount> skull(s)
    And Player score more than <score>
    Examples:
      | test     | fortuneCard | rollResult                                                                       | reRollIndexes | reRollResult        | reRollIndexes2 | reRollResult2        | skullCount | score |
      | "Test71" | "sorceress" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=monkey, 5=diamond, 6=diamond, 7=coin" | "6,7"         | "6=skull, 7=monkey" | "6,7"          | "6=monkey, 7=parrot" | 0          | 300   |

  @Test72
  Scenario Outline: Test72
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2> due to sorceress, and get <reRollResult2>
    Then Player get <skullCount> skull(s)
    And Player can go to next round <can>
    Examples:
      | test     | fortuneCard | rollResult                                                                       | reRollIndexes | reRollResult        | reRollIndexes2 | reRollResult2        | skullCount | can  |
      | "Test72" | "sorceress" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=monkey, 5=diamond, 6=diamond, 7=coin" | "6,7"         | "6=skull, 7=monkey" | "6,7"          | "6=monkey, 7=parrot" | 0          | true |