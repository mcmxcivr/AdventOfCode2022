package nl.mcmxcivr.aoc2022.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SupplyStacksTest {

  @Test
  public void testGetTopCratesAfterMovingWith9000() {
    SupplyStacks supplyStacks = SupplyStacks.fromString(TEST_INPUT);
    assertEquals("CMZ", supplyStacks.getTopCratesAfterMovingWith9000());
  }

  @Test
  public void testGetTopCratesAfterMovingWith9001() {
    SupplyStacks supplyStacks = SupplyStacks.fromString(TEST_INPUT);
    assertEquals("MCD", supplyStacks.getTopCratesAfterMovingWith9001());
  }

  private static final String TEST_INPUT = """
          [D]   \s
      [N] [C]   \s
      [Z] [M] [P]
       1   2   3\s

      move 1 from 2 to 1
      move 3 from 1 to 3
      move 2 from 2 to 1
      move 1 from 1 to 2
        """;
}
