package Homework.seven;

public class User {
  private final String name;
  private final int id;

  public User(int id, String name) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public int getId() {
    return id;
  }
}
