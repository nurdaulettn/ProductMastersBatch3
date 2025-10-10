package Homework.five.hard;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("n: ");
    int n = sc.nextInt();
    ArrayList<Integer> nums = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      nums.add(sc.nextInt());
    }
    nums = removeDuplicates(nums);
    System.out.println(nums);
  }

  public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
    for(int i = 0; i < list.size(); i++) {
      int n = list.get(i);
      for(int j = i+1; j < list.size(); j++) {
        if(n == list.get(j)) list.remove(j);
      }
    }
    return list;
  }
}
