package nl.mcmxcivr.aoc2022.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CampCleanupTest {

  @Test
  public void testgetAmountOfFullyOverlappingSections() {
    CampCleanup campCleanup = CampCleanup.fromString(TEST_INPUT);
    assertEquals(2, campCleanup.getAmountOfFullyOverlappingSections());
  }

  @Test
  public void testgetAmountOfOverlappingSections() {
    CampCleanup campCleanup = CampCleanup.fromString(TEST_INPUT);
    assertEquals(4, campCleanup.getAmountOfOverlappingSections());
  }

  private static final String TEST_INPUT = """
      2-4,6-8
      2-3,4-5
      5-7,7-9
      2-8,3-7
      6-6,4-6
      2-6,4-8
      """;
}
