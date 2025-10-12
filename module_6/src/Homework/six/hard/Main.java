package Homework.six.hard;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    SafeList<String> list = new SafeList<>();
    list.add("apple");
    list.add("banana");
    list.add(null);       // Не добавляется
    list.add("apple");    // Не добавляется

    System.out.println(list.get(0));
    System.out.println(list.get(5));
  }

  public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
    return null;
  }
}
