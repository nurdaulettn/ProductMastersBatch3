package Homework.seven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TwitterService {

  private final List<Post> posts = new ArrayList<>();

  public void initializePosts() {
     posts.add(new Post(new User(1, "Alice"), "Привет, мир!"));
     posts.add(new Post(new User(2, "Bob"), "Сегодня отличный день!"));
     posts.add(new Post(new User(3, "Charlie"), "Люблю программировать на Java."));
     System.out.println("Добавлены стартовые посты.");
  }

  public void addPost(User user, String text) {
    if (text.length()>280){
      System.out.println("Текст превышает допустимую длинну!");
    }else {
      posts.add(new Post(user, text));
    }

  }
  public void likePost(int id){
    Optional<Post> post = posts.stream().filter(p -> p.getId() == id).findFirst();
    if (post.isPresent()) {
      post.get().likePost();
      System.out.println("Вы успешно лайкнули пост под id: "+id);
    }else{
      System.out.println("Токого поста не существует!");
    }
  }
  public void repostPost(int id){
    Optional<Post> post = posts.stream().filter(p -> p.getId() == id).findFirst();
    if (post.isPresent()) {
      post.get().repostPost();
      System.out.println("Вы успешно репостнули пост под id: "+id);
    }else{
      System.out.println("Токого поста не существует!");
    }
  }

  public List<Post> getPosts() {
    return posts;
  }

  public List<Post> getPopularPosts() {
    List<Post> popularPosts = posts.stream()
            .sorted(Comparator.comparingInt(Post::getLikes).reversed())
            .toList();
    return popularPosts;
  }
  public List<Post> getUsersPosts(User user) {
    List<Post> userPosts = posts.stream().filter(p -> p.getAuthor().getId() == user.getId() ).toList();
    return userPosts;
  }





}
