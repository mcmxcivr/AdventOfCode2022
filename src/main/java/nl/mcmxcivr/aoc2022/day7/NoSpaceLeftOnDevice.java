package nl.mcmxcivr.aoc2022.day7;

import java.util.ArrayList;
import java.util.List;

public class NoSpaceLeftOnDevice {

  private final File root;

  public int getTotalSizeOfDirectoriesSmallerThan1000() {
    List<File> files = root.calculateSizes(new ArrayList<>());
    return files.stream() //
        .mapToInt(File::getSize) //
        .filter(size -> size <= 100_000) //
        .sum();
  }

  public int getSmallestToDelete() {
    List<File> files = root.calculateSizes(new ArrayList<>());

    int unused = 70_000_000 - root.getSize();
    int smallestSizeToDelete = Integer.MAX_VALUE;

    for (var file : files) {
      if (unused + file.getSize() > 30_000_000 && file.getSize() < smallestSizeToDelete) {
        smallestSizeToDelete = file.getSize();
      }
    }
    return smallestSizeToDelete;
  }

  private NoSpaceLeftOnDevice(File root) {
    this.root = root;
  }

  public static NoSpaceLeftOnDevice fromString(String input) {
    String[] commands = input.split("\n");

    File root = new File("");

    File current = new File("");
    for (var command : commands) {
      command = command.replace("$ ", "");
      if (!command.equals("ls")) {
        String[] pair = command.split(" ");
        String first = pair[0];
        String second = pair[1];

        if (first.equals("cd")) { // Change dir
          if (second.equals("/")) { // create root
            root = new File(pair[1]);
            root.setDir(true);
            current = root;
          } else if (second.equals("..")) { // go back
            current = current.getParent();
          } else { // go forward
            current = current.getChildren().stream().filter(f -> f.getName().equals(second)).findFirst().get();
          }

        } else if (first.equals("dir")) { // Directory
          File file = new File(second);
          file.setParent(current);
          file.setDir(true);
          current.addChild(file);

        } else { // File
          File file = new File(second, Integer.parseInt(first));
          file.setParent(current);
          current.addChild(file);
        }
      }
    }
    return new NoSpaceLeftOnDevice(root);
  }
}
