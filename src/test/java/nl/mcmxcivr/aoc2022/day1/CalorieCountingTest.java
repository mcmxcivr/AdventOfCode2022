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

  private static final String TEST_INPUT = "1000\n" + "2000\n" + "3000\n" + "\n" + "4000\n" + "\n" + "5000\n" + "6000\n"
      + "\n" + "7000\n" + "8000\n" + "9000\n" + "\n" + "10000";

}
