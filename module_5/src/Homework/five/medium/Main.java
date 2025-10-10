package Homework.five.medium;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    ArrayList<DayOfWeek> days = new ArrayList<DayOfWeek>();
    days.add(DayOfWeek.MONDAY);
    days.add(DayOfWeek.TUESDAY);
    days.add(DayOfWeek.WEDNESDAY);
    days.add(DayOfWeek.THURSDAY);
    days.add(DayOfWeek.FRIDAY);
    days.add(DayOfWeek.SATURDAY);
    days.add(DayOfWeek.SUNDAY);

    for(DayOfWeek day : days) {
      System.out.println(day);
      System.out.println("Is weekend: "+isWeekend(day));
    }
  }
  public static boolean isWeekend(DayOfWeek day) {
    if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
      return true;
    }
    return false;
  }

}
