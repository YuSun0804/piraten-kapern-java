@tag
Feature: Test features for Level 1a-without re-roll
  I want to use this to scenario in level 1a-without re-roll

  @WithoutReRoll
  Scenario Outline: scoring without re-roll
    Given Start <test>
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | test     | fortuneCard | rollResult                                                                        | score |
      | "Test38" | "gold_coin" | "0=skull, 1=skull, 2=skull, 3=monkey, 4=monkey, 5=diamond, 6=diamond, 7=coin"     | 0     |
      | "Test43" | "captain"   | "0=skull, 1=skull, 2=parrot, 3=parrot, 4=diamond, 5=diamond, 6=coin, 7=coin"      | 800   |
      | "Test45" | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=parrot, 7=parrot"     | 300   |
      | "Test47" | "gold_coin" | "0=diamond, 1=diamond, 2=diamond, 3=monkey, 4=sword, 5=sword, 6=parrot, 7=parrot" | 500   |
      | "Test48" | "diamonds"  | "0=coin, 1=coin, 2=coin, 3=coin, 4=sword, 5=sword, 6=parrot, 7=parrot"            | 700   |
      | "Test49" | "gold_coin" | "0=sword, 1=sword, 2=sword, 3=monkey, 4=parrot, 5=parrot, 6=parrot, 7=parrot"     | 400   |
      | "Test53" | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=monkey, 5=monkey, 6=parrot, 7=parrot"  | 1100  |
      | "Test54" | "gold_coin" | "0=parrot, 1=parrot, 2=parrot, 3=parrot, 4=parrot, 5=parrot, 6=parrot, 7=monkey"  | 2100  |
      | "Test55" | "gold_coin" | "0=coin, 1=coin, 2=coin, 3=coin, 4=coin, 5=coin, 6=coin, 7=coin"                  | 5400  |
      | "Test56" | "diamonds"  | "0=coin, 1=coin, 2=coin, 3=coin, 4=coin, 5=coin, 6=coin, 7=coin"                  | 5400  |
      | "Test57" | "captain"   | "0=sword, 1=sword, 2=sword, 3=sword, 4=sword, 5=sword, 6=sword, 7=sword"          | 9000  |
      | "Test63" | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=sword, 5=sword, 6=coin, 7=coin"        | 600   |