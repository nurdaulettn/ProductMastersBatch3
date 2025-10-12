package Homework.six.hard;

import java.util.ArrayList;
import java.util.List;

public class SafeList<T> {
    List<T> list;
    public SafeList(List<T> list) {
        this.list = list;
    }
    public SafeList() {
        this.list = new ArrayList<>();
    }
    public void add(T t) {
        if(t==null) return;
        if(list.contains(t)) return;
        list.add(t);
    }
    public T get(int index) {
        if(index<0 || index>=list.size()) return null;
        return list.get(index);
    }
}
