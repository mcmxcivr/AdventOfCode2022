package nl.mcmxcivr.aoc2022.day1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Elf(List<Integer> calories) {
  public int getTotalCalories() {
    return calories.stream().mapToInt(Integer::intValue).sum();
  }
}


class CalorieCounting {

  private final List<Elf> elves;

  private CalorieCounting(List<Elf> elves) {
    this.elves = elves;
  }

  public int getMaxAmountOfCalories() {
    return this.elves.stream() //
        .max(Comparator.comparingInt(Elf::getTotalCalories)) //
        .map(Elf::getTotalCalories) //
        .orElse(0);
  }

  public int getTopThreeAmountOfCalories() {
    return this.elves.stream() //
        .sorted(Comparator.comparingInt(Elf::getTotalCalories)) //
        .map(Elf::getTotalCalories) //
        .sorted(Collections.reverseOrder()) //
        .limit(3) //
        .mapToInt(Integer::valueOf) //
        .sum();
  }

  public static CalorieCounting fromString(String input) {
    List<Elf> elves = Arrays.stream(input.split("\n\n")) //
        .map(elf -> Arrays.stream(elf.split("\n")) //
            .map(Integer::parseInt) //
            .collect(Collectors.toList()))
        .map(Elf::new)//
        .collect(Collectors.toList());
    return new CalorieCounting(elves);
  }
}
