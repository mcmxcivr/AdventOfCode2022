package nl.mcmxcivr.aoc2022.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NoSpaceLeftOnDeviceTest {

  @Test
  public void testGetTotalSizeOfDirectoriesSmallerThan1000() {
    NoSpaceLeftOnDevice noSpaceLeftOnDevice = NoSpaceLeftOnDevice.fromString(TEST_INPUT);
    assertEquals(95437, noSpaceLeftOnDevice.getTotalSizeOfDirectoriesSmallerThan1000());
  }

  @Test
  public void testGetTotalSize() {
    NoSpaceLeftOnDevice noSpaceLeftOnDevice = NoSpaceLeftOnDevice.fromString(TEST_INPUT);
    assertEquals(24933642, noSpaceLeftOnDevice.getSmallestToDelete());
  }

  private static final String TEST_INPUT = """
      $ cd /
      $ ls
      dir a
      14848514 b.txt
      8504156 c.dat
      dir d
      $ cd a
      $ ls
      dir e
      29116 f
      2557 g
      62596 h.lst
      $ cd e
      $ ls
      584 i
      $ cd ..
      $ cd ..
      $ cd d
      $ ls
      4060174 j
      8033020 d.log
      5626152 d.ext
      7214296 k
      """;
}
