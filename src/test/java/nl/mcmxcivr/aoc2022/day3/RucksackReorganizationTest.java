package nl.mcmxcivr.aoc2022.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RucksackReorganizationTest {

  @Test
  public void testSumItemTypePriorities() {
    RucksackReorganization rucksackReorganization = RucksackReorganization.fromString(TEST_INPUT);
    assertEquals(157, rucksackReorganization.sumItemTypePriorities());
  }

  @Test
  void testSumItemTypePrioritiesForGroupsOfThree() {
    RucksackReorganization rucksackReorganization = RucksackReorganization.fromString(TEST_INPUT);
    assertEquals(70, rucksackReorganization.sumItemTypePrioritiesForGroupsOfThree());
  }

  private static final String TEST_INPUT = """
      vJrwpWtwJgWrhcsFMMfFFhFp
      jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
      PmmdzqPrVvPwwTWBwg
      wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
      ttgJtRGJQctTZtZT
      CrZsJsPPZsGzwwsLwLmpwMDw
      """;
}
