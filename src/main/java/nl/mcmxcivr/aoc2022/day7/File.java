package nl.mcmxcivr.aoc2022.day7;

import java.util.ArrayList;
import java.util.List;

class File {

  private final List<File> children = new ArrayList<>();
  private File parent;
  private final String name;
  private int size;
  private boolean isDir;

  public File(String name) {
    this.name = name;
  }

  public File(String name, int size) {
    this.name = name;
    this.size = size;
  }

  public List<File> calculateSizes(List<File> directories) {
    if (isDir()) {
      List<File> withoutSize = children.stream().filter(f -> f.isDir && f.size == 0).toList();
      while (withoutSize.size() != 0) {
        withoutSize.get(0).calculateSizes(directories);
        withoutSize = children.stream().filter(f -> f.isDir && f.size == 0).toList();
      }
      size = children.stream().mapToInt(f -> f.size).sum();
      directories.add(this);
    }
    return directories;
  }

  public boolean isDir() {
    return isDir;
  }

  public void setDir(boolean dir) {
    isDir = dir;
  }

  public void addChild(File dir) {
    children.add(dir);
  }

  public List<File> getChildren() {
    return children;
  }

  public boolean hasChildren() {
    return children.size() > 0;
  }

  public String getName() {
    return name;
  }

  public File getParent() {
    return parent;
  }

  public void setParent(File parent) {
    this.parent = parent;
  }

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    return hasChildren() ? name + children : name;
  }
}
