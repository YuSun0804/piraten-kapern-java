Feature: Test features for Level 2
  I want to use this to scenario in level 2

  @T125
  Scenario: T125
    Given Start Game Server
    When Player 1251 start
    And Player 1252 start
    And Player 1253 start
    And Player 1251 draw fortuneCard
    And Player 1251 roll dice
    And Player 1251 send score
    And Player 1252 draw fortuneCard
    And Player 1252 roll dice
    And Player 1252 send score
    And Player 1253 draw fortuneCard
    And Player 1253 roll dice
    And Player 1253 send score
    Then Compute Winner 1253 9000

  @T127
  Scenario: T127
    Given Start Game Server
    When Player 1271 start
    And Player 1272 start
    And Player 1273 start
    And Player 1271 draw fortuneCard
    And Player 1271 roll dice
    And Player 1271 send score
    And Player 1272 draw fortuneCard
    And Player 1272 roll dice
    And Player 1272 send score
    And Player 1273 draw fortuneCard
    And Player 1273 roll dice
    And Player 1273 send score
    And Compute Winner 0 0
    And Player 1271 start next turn
    And Player 1272 start next turn
    And Player 1273 start next turn
    And Player 1271 draw fortuneCard
    And Player 1271 roll dice
    And Player 1271 send score
    And Player 1272 draw fortuneCard
    And Player 1272 roll dice
    And Player 1272 send score
    And Player 1273 draw fortuneCard
    And Player 1273 roll dice
    And Player 1273 send score
    And Compute Winner 0 0
    And Player 1271 start next turn
    And Player 1272 start next turn
    And Player 1273 start next turn
    And Player 1271 draw fortuneCard
    And Player 1271 roll dice
    And Player 1271 send score
    And Player 1272 draw fortuneCard
    And Player 1272 roll dice
    And Player 1272 send score
    And Player 1273 draw fortuneCard
    And Player 1273 roll dice
    And Player 1273 send score
    And Compute Winner 1272 9400
	
