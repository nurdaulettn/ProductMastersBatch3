package Homework.seven;

public class Post {
    private int id;
    private String text;
    private User author;
    private static int postCounter = 0;
    private int likes = 0;
    private int reposts = 0;

    public Post(User author, String text) {
        id = ++postCounter;
        this.author = author;
        this.text = text;
    }
    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public User getAuthor() {
        return author;
    }
    public void likePost(){
        likes++;
    }
    public int getLikes() {
        return likes;
    }
    public void repostPost(){
        reposts++;
    }
    @Override
    public String toString() {
        String str = "-----------------------------------"+
                "\nId: "+id+
                "\nAuthor: "+author.getName()+
                "\nLikes: "+likes+"  |  Reposts: "+reposts+
                "\nText: "+text+
                "\n-----------------------------------";
        return str;

    }
}
