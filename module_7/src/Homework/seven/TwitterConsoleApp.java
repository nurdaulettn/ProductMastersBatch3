package Homework.seven;
import java.util.*;


public class TwitterConsoleApp {
  private static final Scanner scanner = new Scanner(System.in);
  private static final TwitterService twitterService = new TwitterService();

  public static void main(String[] args) {
    new TwitterConsoleApp().run();
  }

  public void run() {
    System.out.print("Введите ваше имя: ");
    String userName = scanner.nextLine().trim();
    User currentUser = new User(0, userName);
    System.out.println("Добро пожаловать, " + currentUser.getName() + "!");

    twitterService.initializePosts();

    while (true) {
      showMenu();
      int choice = getIntInput();
      switch (choice) {
        case 1 -> {
          System.out.print("Введите текст поста: ");
          String text = scanner.nextLine().trim();
          twitterService.addPost(currentUser, text);
        }
        case 2 -> {
          System.out.print("Введите id поста: ");
          int id = getIntInput();
          twitterService.likePost(id);
        }
        case 3 -> {
          System.out.print("Введите id поста: ");
          int id = getIntInput();
          twitterService.repostPost(id);
        }
        case 4 -> {
          List<Post> posts = twitterService.getPosts();
          posts.forEach(System.out::println);
        }
        case 5 -> {
          List<Post> posts = twitterService.getPopularPosts();
          posts.forEach(System.out::println);
        }
        case 6 -> {
          List<Post> posts = twitterService.getUsersPosts(currentUser);
          posts.forEach(System.out::println);
        }
        case 7 -> {
          System.out.println("Выход...");
          return;
        }
        default -> System.out.println("Некорректный ввод. Попробуйте снова.");
      }
    }
  }

  private int getIntInput() {
    int input;
    try {
      input = Integer.parseInt(scanner.nextLine().trim());
    } catch (NumberFormatException e) {
      System.out.println("Некорректный ввод.");
      return -1;
    }
    return input;
  }

  private static void showMenu() {
    System.out.println("\n=== Twitter Console ===");
    System.out.println("1. Написать пост");
    System.out.println("2. Лайкнуть пост");
    System.out.println("3. Сделать репост");
    System.out.println("4. Показать все посты");
    System.out.println("5. Показать популярные посты");
    System.out.println("6. Показать мои посты");
    System.out.println("7. Выход");
    System.out.print("Выберите действие: ");
  }

}
