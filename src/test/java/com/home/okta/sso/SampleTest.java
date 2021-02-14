package com.home.okta.sso;

import com.home.okta.sso.models.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class SampleTest {
  private static final Logger log = LoggerFactory.getLogger(SampleTest.class);

  @Test
  public void doSomething() {
    Set<User> users = new HashSet<>();

    User user = new User();
    user.setEmail("one@gmail.com");
    user.setFirstName("oneFirstName");
    user.setFullName("oneFullName");
    user.setLastName("oneLastName");

    users.add(user);

    User user1 = new User();
    user1.setEmail("two@gmail.com");
    user1.setFirstName("twoFirstName");
    user1.setFullName("twoFullName");
    user1.setLastName("twoLastName");

    users.add(user1);

    users.forEach(u -> {
      log.info("user: {}", u);
    });

  }

}
