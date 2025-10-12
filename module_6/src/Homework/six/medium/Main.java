package Homework.six.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("C:\\Users\\nurda\\Desktop\\Proga\\javaCodes\\ProductMastersBatch3\\module_6\\src\\Homework\\six\\medium\\words.txt");
    Scanner scan = new Scanner(file);
    HashMap<String, Integer> map = new HashMap<>();
    while(scan.hasNextLine()) {
      String line = scan.nextLine();
      String[] words = line.split(" ");
      for(String word : words) {
        if(map.containsKey(word)) map.put(word, map.get(word) + 1);
        else map.put(word, 1);
      }
    }
    for(Map.Entry<String, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}
