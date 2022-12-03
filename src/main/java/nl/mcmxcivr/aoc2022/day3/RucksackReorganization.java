package nl.mcmxcivr.aoc2022.day3;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RucksackReorganization {

  private final List<String> rucksacks;

  private RucksackReorganization(List<String> rucksacks) {
    this.rucksacks = rucksacks;
  }

  public int sumItemTypePrioritiesForGroupsOfThree() {
    Collection<List<String>> batches = IntStream.range(0, rucksacks.size()) //
        .boxed() //
        .collect(Collectors.groupingBy(partition -> (partition / 3), //
            Collectors.mapping(rucksacks::get, Collectors.toList()))) //
        .values();

    return batches.stream() //
        .map(this::findCommonItemType) //
        .map(this::calculatePriority) //
        .mapToInt(Integer::valueOf) //
        .sum();
  }

  public int sumItemTypePriorities() {
    return rucksacks.stream() //
        .map(r -> findCommon(toCharacterSet(r.substring(0, (r.length() / 2))), r.substring(r.length() / 2)).stream()
            .findFirst() //
            .orElseThrow(() -> new IllegalStateException("Missing common type item"))) //
        .map(this::calculatePriority) //
        .mapToInt(Integer::intValue) //
        .sum();
  }

  private char findCommonItemType(List<String> rucksacks) {
    Set<Character> charactersLeft = findCommon(toCharacterSet(rucksacks.get(0)), rucksacks.get(1));
    Set<Character> common = findCommon(charactersLeft, rucksacks.get(2));
    return common.stream() //
        .findFirst() //
        .orElseThrow(() -> new IllegalStateException("Missing common type item"));
  }

  private Set<Character> findCommon(Set<Character> left, String items) {
    return left.stream() //
        .filter(c -> items.contains(c + "")) //
        .collect(Collectors.toSet());
  }

  private int calculatePriority(char type) {
    return (type > 64 && type < 91) ? (type - 65) + 27 : type - 96;
  }

  private Set<Character> toCharacterSet(String string) {
    return string.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
  }

  public static RucksackReorganization fromString(String input) {
    return new RucksackReorganization(Arrays.stream(input.split("\n")).toList());
  }
}
