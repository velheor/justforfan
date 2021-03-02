package com.algo.comparatorTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserComparatorTest {

  private final User user1;

  private final User user2;

  private final User user3;

  private UserComparator userComparator;

  private final List<User> users;

  UserComparatorTest() {
    user1 = new User("Abc", 18);
    user2 = new User("Bac", 20);
    user3 = new User("Cab", 19);

    users = new ArrayList<>();

    users.add(user3);
    users.add(user2);
    users.add(user1);
  }

  @Test
  void compare() {
    System.out.println("Before sort");
    users.forEach(user -> System.out.println(user.toString()));

    users.sort(Comparator.comparing(User::getName));

    System.out.println("After sort");
    users.forEach(user -> System.out.println(user.toString()));


    System.out.println("After sort");
    users.sort(Comparator.comparing(User::getAge).thenComparing(User::getName));
    users.forEach(user -> System.out.println(user.toString()));
  }

  @Test
  void regexNumber() {
    String number = "228";
    assertTrue(number.matches("\\d+"));
  }

  @Test
  void stream(){
    assertTrue(users.stream().anyMatch(user -> user.getName().equals("Abc")));
  }
}