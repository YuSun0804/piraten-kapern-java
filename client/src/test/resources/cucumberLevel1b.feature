@tag
Feature: Test features for Level 1a
  I want to use this to scenario in level 1a

  @Test70
  Scenario Outline: Test70
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice due to sorceress
    Then Player get <skullCount> skull(s)
    And Player can go to next round <can>
    Examples:
      | fortuneCard | rollResult                                                                     | skullCount | can  |
      | "sorceress" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=monkey, 5=diamond, 6=diamond, 7=coin" | 1          | true |

  @Test71
  Scenario Outline: Test71
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice due to sorceress
    Then Player get <skullCount> skull(s)
    And Player score more than <score>
    Examples:
      | fortuneCard | rollResult                                                                       | reRollIndexes | reRollResult        | skullCount | score |
      | "sorceress" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=monkey, 5=diamond, 6=diamond, 7=coin" | "6,7"         | "6=skull, 7=monkey" | 0          | 300   |

  @Test72
  Scenario Outline: Test72
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice due to sorceress
    Then Player get <skullCount> skull(s)
    And Player can go to next round <can>
    Examples:
      | fortuneCard | rollResult                                                                       | reRollIndexes | reRollResult        | skullCount | can  |
      | "sorceress" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=monkey, 5=diamond, 6=diamond, 7=coin" | "6,7"         | "6=skull, 7=monkey" | 0          | true |

  @Test75
  Scenario Outline: Test75
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard       | rollResult                                                                    | score |
      | "monkey_business" | "0=skull, 1=parrot, 2=parrot, 3=parrot, 4=monkey, 5=monkey, 6=monkey, 7=coin" | 1100  |

  @Test76
  Scenario Outline: Test76
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard       | rollResult                                                                | reRollIndexes | reRollResult                  | reRollIndexes2 | reRollResult2      | score |
      | "monkey_business" | "0=monkey, 1=monkey, 2=parrot, 3=coin, 4=coin, 5=sword, 6=sword, 7=sword" | "5,6,7"       | "5=diamond, 6=sword, 7=sword" | "6,7"          | "6=sword, 7=sword" | 400   |

  @Test77
  Scenario Outline: Test77
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard       | rollResult                                                                    | reRollIndexes | reRollResult                 | reRollIndexes2 | reRollResult2       | score |
      | "monkey_business" | "0=monkey, 1=monkey, 2=monkey, 3=parrot, 4=parrot, 5=sword, 6=sword, 7=sword" | "5,6,7"       | "5=parrot, 6=sword, 7=sword" | "6,7"          | "6=parrot, 7=sword" | 2000  |

  @Test80
  Scenario Outline: Test80
    Given Start Game
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
    Given Start Game
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

  @Test91
  Scenario Outline: Test91
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                     | score |
      | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=diamond, 7=parrot" | 400   |

  @Test92
  Scenario Outline: Test92
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                | score |
      | "captain"   | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=coin, 7=coin" | 1800  |

  @Test93
  Scenario Outline: Test93
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                    | score |
      | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=sword, 7=diamond" | 1000  |

  @Test94
  Scenario Outline: Test94
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                    | reRollIndexes | reRollResult      | score |
      | "two_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=sword, 5=parrot, 6=parrot, 7=coin" | "5,6"         | "5=coin, 6=sword" | 1200  |

  @Test97
  Scenario Outline: Test97
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard       | rollResult                                                                      | score |
      | "monkey_business" | "0=monkey, 1=monkey, 2=parrot, 3=coin, 4=coin, 5=diamond, 6=diamond, 7=diamond" | 1200  |

  @Test100
  Scenario Outline: Test100
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                     | score |
      | "two_skull" | "0=skull, 1=monkey, 2=parrot, 3=coin, 4=coin, 5=diamond, 6=diamond, 7=diamond" | 0     |

  @Test101
  Scenario Outline: Test101
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                    | score |
      | "one_skull" | "0=skull, 1=skull, 2=parrot, 3=coin, 4=coin, 5=diamond, 6=diamond, 7=diamond" | 0     |

  @Test102
  Scenario Outline: Test102
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    When Roll dice, and get <rollResult>
    Then Player make <deduction> deduction to all other players
    Examples:
      | fortuneCard | rollResult                                                                   | deduction |
      | "captain"   | "0=skull, 1=skull, 2=skull, 3=skull, 4=skull, 5=monkey, 6=monkey, 7=diamond" | -1000     |

  @Test103
  Scenario Outline: Test103
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player make <deduction> deduction to all other players
    Examples:
      | fortuneCard | rollResult                                                                    | reRollIndexes | reRollResult       | reRollIndexes2 | reRollResult2       | deduction |
      | "two_skull" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=parrot, 5=parrot, 6=coin, 7=diamond" | "2,3"         | "2=skull, 3=skull" | "4,5"          | "4=skull, 5=monkey" | -700      |

  @Test104
  Scenario Outline: Test104
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player make <deduction> deduction to all other players
    Examples:
      | fortuneCard | rollResult                                                                   | reRollIndexes | reRollResult         | deduction |
      | "two_skull" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=skull, 5=parrot, 6=coin, 7=diamond" | "2,3"         | "2=monkey, 3=monkey" | -500      |

  @Test105
  Scenario Outline: Test105
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player make <deduction> deduction to all other players
    Examples:
      | fortuneCard | rollResult                                                                  | reRollIndexes | reRollResult        | reRollIndexes2 | reRollResult2        | deduction |
      | "one_skull" | "0=skull, 1=skull, 2=skull, 3=monkey, 4=parrot, 5=parrot, 6=coin, 7=parrot" | "3,4"         | "3=skull, 4=monkey" | "4,5"          | "4=monkey, 5=monkey" | -500      |

  @Test109
  Scenario Outline: Test109
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player lose <deduction>
    Examples:
      | fortuneCard | rollResult                                                                  | deduction |
      | "two_sabre" | "0=skull, 1=skull, 2=skull, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword" | -300      |

  @Test110
  Scenario Outline: Test110
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player lose <deduction>
    Examples:
      | fortuneCard   | rollResult                                                                  | deduction |
      | "three_sabre" | "0=skull, 1=skull, 2=skull, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword" | -500      |

  @Test111
  Scenario Outline: Test111
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player lose <deduction>
    Examples:
      | fortuneCard  | rollResult                                                                  | deduction |
      | "four_sabre" | "0=skull, 1=skull, 2=skull, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword" | -1000     |


  @Test113
  Scenario Outline: Test113
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                   | score |
      | "two_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=coin, 6=parrot, 7=parrot" | 500   |

  @Test114
  Scenario Outline: Test114
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                     | reRollIndexes | reRollResult       | score |
      | "two_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=sword, 5=skull, 6=parrot, 7=parrot" | "6,7"         | "6=skull, 7=sword" | 500   |

  @Test116
  Scenario Outline: Test116
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard   | rollResult                                                                   | score |
      | "three_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=sword, 7=parrot" | 800   |

  @Test117
  Scenario Outline: Test117
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard   | rollResult                                                                   | reRollIndexes | reRollResult                         | score |
      | "three_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=sword, 5=sword, 6=skull, 7=skull" | "0,1,2,3"     | "0=skull, 1=skull, 2=sword, 3=sword" | 0     |

  @Test119
  Scenario Outline: Test119
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard  | rollResult                                                                  | score |
      | "four_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=sword, 7=skull" | 1300  |

  @Test120
  Scenario Outline: Test120
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard  | rollResult                                                                      | reRollIndexes | reRollResult       | reRollIndexes2 | reRollResult2                 | score |
      | "four_sabre" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=skull, 5=diamond, 6=parrot, 7=parrot" | "6,7"         | "6=sword, 7=sword" | "0,1,2"        | "0=sword, 1=parrot, 2=parrot" | 1300  |