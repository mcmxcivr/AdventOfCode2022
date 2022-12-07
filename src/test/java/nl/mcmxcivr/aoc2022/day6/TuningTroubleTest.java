package nl.mcmxcivr.aoc2022.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TuningTroubleTest {

  @Test
  public void testGetAmountOfCharactersBeforeMarker() {
    TuningTrouble tuningTrouble = new TuningTrouble();
    assertEquals(5, tuningTrouble.getAmountOfCharactersBeforeMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 4));
    assertEquals(6, tuningTrouble.getAmountOfCharactersBeforeMarker("nppdvjthqldpwncqszvftbrmjlhg", 4));
    assertEquals(10, tuningTrouble.getAmountOfCharactersBeforeMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4));
    assertEquals(11, tuningTrouble.getAmountOfCharactersBeforeMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4));

    assertEquals(19, tuningTrouble.getAmountOfCharactersBeforeMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14));
    assertEquals(23, tuningTrouble.getAmountOfCharactersBeforeMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 14));
    assertEquals(23, tuningTrouble.getAmountOfCharactersBeforeMarker("nppdvjthqldpwncqszvftbrmjlhg", 14));
    assertEquals(29, tuningTrouble.getAmountOfCharactersBeforeMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14));
    assertEquals(26, tuningTrouble.getAmountOfCharactersBeforeMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14));
  }
}
