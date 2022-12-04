package nl.mcmxcivr.aoc2022.day4;

import java.util.Arrays;
import java.util.List;

record Section(int x1, int x2) {
}


record ElfPair(Section one, Section two) {
}


public class CampCleanup {

  private final List<ElfPair> elfPairs;

  public long getAmountOfFullyOverlappingSections() {
    return elfPairs.stream() //
        .filter(this::hasFullyOverlappingSections) //
        .count();
  }

  public long getAmountOfOverlappingSections() {
    return elfPairs.stream() //
        .filter(this::hasOverlappingSections) //
        .count();
  }

  private boolean hasFullyOverlappingSections(ElfPair elfPair) {
    boolean overlappingFirst = elfPair.one().x1() <= elfPair.two().x1() && elfPair.one().x2() >= elfPair.two().x2();
    boolean overlappingSecond = elfPair.two().x1() <= elfPair.one().x1() && elfPair.two().x2() >= elfPair.one().x2();
    return overlappingFirst || overlappingSecond;
  }

  private boolean hasOverlappingSections(ElfPair elfPair) {
    return !(elfPair.one().x2() < elfPair.two().x1() || elfPair.two().x2() < elfPair.one().x1());
  }

  private CampCleanup(List<ElfPair> elfPairs) {
    this.elfPairs = elfPairs;
  }

  public static CampCleanup fromString(String input) {
    return new CampCleanup(Arrays.stream(input.split("\n")) //
        .map(CampCleanup::toElfPair) //
        .toList());
  }

  private static ElfPair toElfPair(String pair) {
    String[] sections = pair.split(",");
    String[] section1 = sections[0].split("-");
    String[] section2 = sections[1].split("-");
    return new ElfPair(new Section(Integer.parseInt(section1[0]), Integer.parseInt(section1[1])),
        new Section(Integer.parseInt(section2[0]), Integer.parseInt(section2[1])));
  }
}
