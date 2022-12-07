package nl.mcmxcivr.aoc2022.day6;

import java.util.Set;
import java.util.stream.Collectors;

public class TuningTrouble {

  public int getAmountOfCharactersBeforeMarker(String input, int amountForMarker) {
    for (int i = amountForMarker; i < input.length(); i++) {
      Set<Character> characterSet = input.substring(i - amountForMarker, i) //
          .chars() //
          .mapToObj(c -> (char) c) //
          .collect(Collectors.toSet());
      if (characterSet.size() == amountForMarker) {
        return i;
      }
    }
    throw new IllegalStateException("Marker not found");
  }
}
