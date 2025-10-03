package Homework.hard;

public class Main {

  public static void main(String[] args) {
    Box<String> box1 = new Box<>("Hello");
    System.out.println(box1.getItem());
    box1.setItem("World");
    System.out.println(box1.getItem());
    box1.showType();
    Box<Integer> box2 = new Box<>(543890);
    System.out.println(box2.getItem());
    box2.showType();
  }

}
