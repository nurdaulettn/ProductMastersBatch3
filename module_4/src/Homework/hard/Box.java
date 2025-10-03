package Homework.hard;

public class Box<T> {
    T item;
    Box(T item) {
        this.item = item;
    }
    public void setItem(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
    public void showType(){
        System.out.println(item.getClass().getSimpleName());
    }
}
