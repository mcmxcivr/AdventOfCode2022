package nl.mcmxcivr.aoc2022.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

record Move(int amount, int source, int destination) {
  static Move fromString(String input) {
    String[] splitFrom = input.split(" from ");
    String[] move = splitFrom[1].split(" to ");
    return new Move(Integer.parseInt(splitFrom[0]), Integer.parseInt(move[0]), Integer.parseInt(move[1]));
  }
}


public class SupplyStacks {

  private final List<LinkedList<Character>> stacks;
  private final List<Move> moves;

  private SupplyStacks(List<LinkedList<Character>> stacks, List<Move> moves) {
    this.stacks = stacks;
    this.moves = moves;
  }

  public String getTopCratesAfterMovingWith9000() {
    doMovesOneByOne();
    return getTopCrates();
  }

  public String getTopCratesAfterMovingWith9001() {
    doMovesTogether();
    return getTopCrates();
  }

  private void doMovesOneByOne() {
    for (var move : moves) {
      for (int i = 0; i < move.amount(); i++) {
        Character pop = stacks.get(move.source() - 1).pollLast();
        stacks.get(move.destination() - 1).addLast(pop);
      }
    }
  }

  private void doMovesTogether() {
    for (var move : moves) {
      LinkedList<Character> popped = new LinkedList<>();
      for (int i = 0; i < move.amount(); i++) {
        Character pop = stacks.get(move.source() - 1).pollLast();
        popped.add(pop);
      }
      int size = popped.size();
      for (int i = 0; i < size; i++) {
        stacks.get(move.destination() - 1).addLast(popped.pollLast());
      }
    }
  }


  private String getTopCrates() {
    return stacks.stream() //
        .map(LinkedList::peekLast).filter(Objects::nonNull) //
        .map(Object::toString) //
        .collect(Collectors.joining());
  }

  public static SupplyStacks fromString(String input) {
    String[] total = input.split("\n\n");
    String stacksString = total[0];
    List<LinkedList<Character>> stacks = new ArrayList<>();
    String[] stackRows = stacksString.split("\n");

    int ceil = stackRows[stackRows.length - 1].replaceAll(" ", "").length();
    for (int i = 0; i < ceil; i++) {
      stacks.add(new LinkedList<>());
    }

    int limit = stackRows.length - 1;
    for (String stackRow : stackRows) {
      if (limit-- == 0)
        break;
      String substring = stackRow.substring(1).substring(0, stackRow.length() - 2);
      for (int i = 0; i < substring.length(); i++) {
        if ((i % 4) == 0) {
          int floor = (int) Math.floor(i / 4);
          char c = substring.charAt(i);
          if (c != ' ') {
            stacks.get(floor).addFirst(c);
          }
        }
      }
    }

    List<Move> moves = Arrays.stream(total[1].split("\n")) //
        .map(s -> s.substring(5)) //
        .map(Move::fromString) //
        .toList();
    return new SupplyStacks(stacks, moves);
  }
}
