@tag
Feature: Test features for Level 1a
  I want to use this to scenario in level 1a

  @Test38
  Scenario Outline: Test38
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                    | score |
      | "gold_coin" | "0=skull, 1=skull, 2=skull, 3=monkey, 4=monkey, 5=diamond, 6=diamond, 7=coin" | 0     |

  @Test39
  Scenario Outline: Test39
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                   | reRollIndexes | reRollResult                | score |
      | "gold_coin" | "0=skull, 1=parrot, 2=parrot, 3=parrot, 4=parrot, 5=sword, 6=sword, 7=sword" | "5,6,7"       | "5=skull, 6=skull, 7=sword" | 0     |

  @Test40
  Scenario Outline: Test40
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                   | reRollIndexes | reRollResult       | score |
      | "gold_coin" | "0=skull, 1=skull, 2=parrot, 3=parrot, 4=parrot, 5=parrot, 6=sword, 7=sword" | "6,7"         | "6=skull, 7=sword" | 0     |

  @Test41
  Scenario Outline: Test41
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                   | reRollIndexes | reRollResult                  | reRollIndexes2 | reRollResult2       | score |
      | "gold_coin" | "0=skull, 1=parrot, 2=parrot, 3=parrot, 4=parrot, 5=sword, 6=sword, 7=sword" | "5,6,7"       | "5=skull, 6=monkey, 7=monkey" | "6,7"          | "6=skull, 7=monkey" | 0     |

  @Test43
  Scenario Outline: Test43
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                   | score |
      | "captain"   | "0=skull, 1=skull, 2=parrot, 3=parrot, 4=diamond, 5=diamond, 6=coin, 7=coin" | 800   |

  @Test44
  Scenario Outline: Test44
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                   | reRollIndexes | reRollResult                  | score |
      | "gold_coin" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword" | "5,6,7"       | "5=monkey, 6=parrot, 7=sword" | 200   |

  @Test45
  Scenario Outline: Test45
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                    | score |
      | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=sword, 4=sword, 5=sword, 6=parrot, 7=parrot" | 300   |

  @Test46
  Scenario Outline: Test46
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                   | reRollIndexes | reRollResult         | score |
      | "gold_coin" | "0=skull, 1=skull, 2=monkey, 3=monkey, 4=parrot, 5=parrot, 6=sword, 7=sword" | "6,7"         | "6=parrot, 7=monkey" | 300   |

  @Test47
  Scenario Outline: Test47
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                        | score |
      | "gold_coin" | "0=diamond, 1=diamond, 2=diamond, 3=monkey, 4=sword, 5=sword, 6=parrot, 7=parrot" | 500   |

  @Test48
  Scenario Outline: Test48
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                             | score |
      | "diamonds"  | "0=coin, 1=coin, 2=coin, 3=coin, 4=sword, 5=sword, 6=parrot, 7=parrot" | 700   |

  @Test49
  Scenario Outline: Test49
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                    | score |
      | "gold_coin" | "0=sword, 1=sword, 2=sword, 3=monkey, 4=parrot, 5=parrot, 6=parrot, 7=parrot" | 400   |

  @Test50
  Scenario Outline: Test50
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                             | reRollIndexes | reRollResult                  | reRollIndexes2 | reRollResult2      | score |
      | "gold_coin" | "0=skull, 1=coin, 2=coin, 3=coin, 4=sword, 5=parrot, 6=money, 7=sword" | "5,6,7"       | "5=sword, 6=monkey, 7=monkey" | "6,7"          | "6=sword, 7=sword" | 800   |

  @Test51
  Scenario Outline: Test51
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                             | reRollIndexes | reRollResult                  | reRollIndexes2 | reRollResult2      | score |
      | "captain"   | "0=skull, 1=coin, 2=coin, 3=coin, 4=sword, 5=parrot, 6=money, 7=sword" | "5,6,7"       | "5=sword, 6=monkey, 7=monkey" | "6,7"          | "6=sword, 7=sword" | 1200  |

  @Test52
  Scenario Outline: Test52
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                 | reRollIndexes | reRollResult                  | reRollIndexes2 | reRollResult2       | score |
      | "gold_coin" | "0=skull, 1=sword, 2=sword, 3=sword, 4=parrot, 5=parrot, 6=money, 7=money" | "5,6,7"       | "5=sword, 6=monkey, 7=monkey" | "6,7"          | "6=sword, 7=monkey" | 600   |

  @Test53
  Scenario Outline: Test53
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                       | score |
      | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=monkey, 5=monkey, 6=parrot, 7=parrot" | 1100  |

  @Test54
  Scenario Outline: Test54
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    When Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                       | score |
      | "gold_coin" | "0=parrot, 1=parrot, 2=parrot, 3=parrot, 4=parrot, 5=parrot, 6=parrot, 7=monkey" | 2100  |

  @Test55
  Scenario Outline: Test55
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                       | score |
      | "gold_coin" | "0=coin, 1=coin, 2=coin, 3=coin, 4=coin, 5=coin, 6=coin, 7=coin" | 5400  |

  @Test56
  Scenario Outline: Test56
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    When Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                       | score |
      | "diamonds"  | "0=coin, 1=coin, 2=coin, 3=coin, 4=coin, 5=coin, 6=coin, 7=coin" | 5400  |

  @Test57
  Scenario Outline: Test57
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                               | score |
      | "captain"   | "0=sword, 1=sword, 2=sword, 3=sword, 4=sword, 5=sword, 6=sword, 7=sword" | 9000  |

  @Test58
  Scenario Outline: Test58
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    And Re-Roll dice <reRollIndexes2>, and get <reRollResult2>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                      | reRollIndexes | reRollResult                  | reRollIndexes2 | reRollResult2        | score |
      | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=monkey, 5=parrot, 6=parrot, 7=sword" | "5,6,7"       | "5=monkey, 6=monkey, 7=sword" | "6,7"          | "6=monkey, 7=monkey" | 4600  |

  @Test59
  Scenario Outline: Test59
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                    | reRollIndexes | reRollResult                   | score |
      | "diamonds"  | "0=diamond, 1=monkey, 2=skull, 3=skull, 4=sword, 5=parrot, 6=parrot, 7=sword" | "5,6,7"       | "5=diamond, 6=monkey, 7=sword" | 400   |

  @Test60
  Scenario Outline: Test60
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    When Roll dice, and get <rollResult>
    When Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                    | reRollIndexes | reRollResult                    | score |
      | "gold_coin" | "0=diamond, 1=monkey, 2=skull, 3=skull, 4=sword, 5=parrot, 6=parrot, 7=sword" | "5,6,7"       | "5=diamond, 6=diamond, 7=sword" | 500   |

  @Test61
  Scenario Outline: Test61
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                 | reRollIndexes | reRollResult              | score |
      | "gold_coin" | "0=coin, 1=monkey, 2=skull, 3=skull, 4=sword, 5=parrot, 6=parrot, 7=sword" | "5,6,7"       | "5=coin, 6=coin, 7=sword" | 600   |

  @Test62
  Scenario Outline: Test62
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    And Re-Roll dice <reRollIndexes>, and get <reRollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                 | reRollIndexes | reRollResult              | score |
      | "diamonds"  | "0=coin, 1=monkey, 2=skull, 3=skull, 4=sword, 5=parrot, 6=parrot, 7=sword" | "5,6,7"       | "5=coin, 6=coin, 7=sword" | 500   |

  @Test63
  Scenario Outline: Test62
    Given Start Game
    When Draw fortuneCard, and get <fortuneCard>
    And Roll dice, and get <rollResult>
    Then Player get <score>
    Examples:
      | fortuneCard | rollResult                                                                 | score |
      | "gold_coin" | "0=monkey, 1=monkey, 2=monkey, 3=monkey, 4=sword, 5=sword, 6=coin, 7=coin" | 600   |

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