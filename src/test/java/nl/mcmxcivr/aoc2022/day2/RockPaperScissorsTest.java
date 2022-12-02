package nl.mcmxcivr.aoc2022.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RockPaperScissorsTest {

  @Test
  void testGetTotalScoreWithStrategyGuide() {
    RockPaperScissors rockPaperScissors = RockPaperScissors.fromString(TEST_INPUT);
    assertEquals(15, rockPaperScissors.getTotalScoreWithSimpleStrategyGuide());
  }

  @Test
  void testGetTotalScoreWithTopSecretStrategyGuide() {
    RockPaperScissors rockPaperScissors = RockPaperScissors.fromString(TEST_INPUT);
    assertEquals(12, rockPaperScissors.getTotalScoreWithTopSecretStrategyGuide());
  }

  private static final String TEST_INPUT = """
      A Y
      B X
      C Z""";
}
