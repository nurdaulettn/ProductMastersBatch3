package Homework.six.easy;
import java.lang.reflect.Array;
import java.util.*;

public class MyList {
    List<Integer> list;
    public MyList(List<Integer> list) {
        this.list = list;
    }
    public int min(){
        return Collections.min(list);
    }
    public int max(){
        return Collections.max(list);
    }
    public List<Integer> sort(){
        Collections.sort(list);
        return list;
    }
    public List<Integer> reverseSort(){
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }
    public boolean have(int n){
        return list.contains(n);
    }
    public List<Integer> greater(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i : list) {
            if(n < i) list.add(i);
        }
        return list;
    }
    public int sum(){
        int sum = 0;
        for(Integer i : list) sum += i;
        return sum;
    }
}
