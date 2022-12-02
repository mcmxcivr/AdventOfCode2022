package nl.mcmxcivr.aoc2022.day2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

record Round(char opponents, char yours) {
}


record Strategy(char winning, char losing, char draw) {
}


class RockPaperScissors {

  public static final char ROCK_OPPONENT = 'A';
  public static final char PAPER_OPPONENT = 'B';
  public static final char SCISSORS_OPPONENT = 'C';
  public static final char ROCK = 'X';
  public static final char PAPER = 'Y';
  public static final char SCISSORS = 'Z';

  private final List<Round> rounds;
  private final Map<Character, Strategy> results;

  private RockPaperScissors(List<Round> rounds) {
    this.rounds = rounds;
    results = Map.of( //
        ROCK_OPPONENT, new Strategy(PAPER, SCISSORS, ROCK), //
        PAPER_OPPONENT, new Strategy(SCISSORS, ROCK, PAPER), //
        SCISSORS_OPPONENT, new Strategy(ROCK, PAPER, SCISSORS));
  }

  public int getTotalScoreWithSimpleStrategyGuide() {
    return rounds.stream() //
        .mapToInt(this::playRound) //
        .sum();
  }

  public int getTotalScoreWithTopSecretStrategyGuide() {
    return rounds.stream() //
        .map(round -> new Round(round.opponents(), getTopSecretStrategyShape(round.yours(), round.opponents()))) //
        .mapToInt(this::playRound) //
        .sum();
  }

  private char getTopSecretStrategyShape(char yours, char opponents) {
    return switch (yours) {
      case ROCK -> results.get(opponents).losing();
      case PAPER -> results.get(opponents).draw();
      case SCISSORS -> results.get(opponents).winning();
      default -> throw new IllegalStateException("Unexpected value: " + yours);
    };
  }

  private int playRound(Round round) {
    Strategy strategy = results.get(round.opponents());

    int points = 3;
    if (strategy.winning() == round.yours())
      points = 6;
    if (strategy.losing() == round.yours())
      points = 0;

    return points + getShapeBonus(round.yours());
  }

  private static int getShapeBonus(char yours) {
    return switch (yours) {
      case ROCK -> 1;
      case PAPER -> 2;
      case SCISSORS -> 3;
      default -> throw new IllegalStateException("Unexpected value: " + yours);
    };
  }

  public static RockPaperScissors fromString(String input) {
    List<Round> rounds = Arrays.stream(input.split("\n")) //
        .map(round -> new Round(round.charAt(0), round.charAt(2))).toList();
    return new RockPaperScissors(rounds);
  }
}
