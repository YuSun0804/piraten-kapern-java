@tag
Feature: Test features for Level 1a-with-re-roll
  I want to use this to scenario in level 1a-with-re-roll


  @WithReRollOnce
  Scenario Outline: scoring with re-roll once
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | test     | fortuneCard | rollResult                                                                    | reRollIndexes | reRollResult                    | score |
      | "Test39" | "gold_coin" | "0=skull, 1=parrot, 2=parrot, 3=parrot, 4=parrot, 5=sword, 6=sword, 7=sword"  | "5,6,7"       | "5=skull, 6=skull, 7=sword"     | 0     |
      | "Test40" | "gold_coin" | "0=skull, 1=skull, 2=parrot, 3=parrot, 4=parrot, 5=parrot, 6=sword, 7=sword"  | "6,7"         | "6=skull, 7=sword"              | 0     |
      | "Test44" | "gold_coin" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword"  | "5,6,7"       | "5=monkey, 6=parrot, 7=sword"   | 200   |
      | "Test46" | "gold_coin" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword"  | "6,7"         | "6=parrot, 7=monkey"            | 300   |
      | "Test59" | "diamonds"  | "0=diamond, 1=monkey, 2=skull, 3=skull, 4=sword, 5=parrot, 6=parrot, 7=sword" | "5,6,7"       | "5=diamond, 6=monkey, 7=sword"  | 400   |
      | "Test60" | "gold_coin" | "0=diamond, 1=monkey, 2=skull, 3=skull, 4=sword, 5=parrot, 6=parrot, 7=sword" | "5,6,7"       | "5=diamond, 6=diamond, 7=sword" | 500   |
      | "Test61" | "gold_coin" | "0=coin, 1=monkey, 2=skull, 3=skull, 4=sword, 5=parrot, 6=parrot, 7=sword"    | "5,6,7"       | "5=coin, 6=coin, 7=sword"       | 600   |
      | "Test62" | "diamonds"  | "0=coin, 1=monkey, 2=skull, 3=skull, 4=sword, 5=parrot, 6=parrot, 7=sword"    | "5,6,7"       | "5=coin, 6=coin, 7=sword"       | 500   |

  @WithReRollTwice
  Scenario Outline: scoring with re-roll twice
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | test     | fortuneCard | rollResult                                                                      | reRollIndexes | reRollResult                  | reRollIndexes2 | reRollResult2        | score |
      | "Test41" | "gold_coin" | "0=skull, 1=parrot, 2=parrot, 3=parrot, 4=parrot, 5=sword, 6=sword, 7=sword"    | "5,6,7"       | "5=skull, 6=monkey, 7=monkey" | "6,7"          | "6=skull, 7=monkey"  | 0     |
      | "Test50" | "gold_coin" | "0=skull, 1=coin, 2=coin, 3=coin, 4=sword, 5=parrot, 6=money, 7=sword"          | "5,6,7"       | "5=sword, 6=monkey, 7=monkey" | "6,7"          | "6=sword, 7=sword"   | 800   |
      | "Test51" | "captain"   | "0=skull, 1=coin, 2=coin, 3=coin, 4=sword, 5=parrot, 6=money, 7=sword"          | "5,6,7"       | "5=sword, 6=monkey, 7=monkey" | "6,7"          | "6=sword, 7=sword"   | 1200  |
      | "Test52" | "gold_coin" | "0=skull, 1=sword, 2=sword, 3=sword, 4=parrot, 5=parrot, 6=money, 7=money"      | "5,6,7"       | "5=sword, 6=monkey, 7=monkey" | "6,7"          | "6=sword, 7=monkey"  | 600   |
      | "Test58" | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=monkey, 5=parrot, 6=parrot, 7=sword" | "5,6,7"       | "5=monkey, 6=monkey, 7=sword" | "6,7"          | "6=monkey, 7=monkey" | 4600  |

  @Test65
  Scenario Outline: Test65
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player re-roll <reRollSuccess>
    Examples:
      | fortuneCard | rollResult                                                              | reRollIndexes | reRollResult | reRollSuccess |
      | "gold_coin" | "0=sword, 1=sword, 2=sword, 3=sword, 4=sword, 5=sword, 6=sword, 7=coin" | "7"           | ""           | false         |