package nl.mcmxcivr.aoc2022.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalorieCountingTest {

  @Test
  public void testMostAmountOfCalories() {
    CalorieCounting calorieCounting = CalorieCounting.fromString(TEST_INPUT);
    assertEquals(24000, calorieCounting.getMaxAmountOfCalories());
  }

  @Test
  public void testTopThreeAmountOfCalories() {
    CalorieCounting calorieCounting = CalorieCounting.fromString(TEST_INPUT);
    assertEquals(45000, calorieCounting.getTopThreeAmountOfCalories());
  }

  private static final String TEST_INPUT = """
      1000
      2000
      3000

      4000

      5000
      6000

      7000
      8000
      9000

      10000""";
}
