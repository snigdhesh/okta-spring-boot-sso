package com.home.okta.sso.services;

import com.home.okta.sso.models.User;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service(value = "user")
public class UserServiceImpl implements IUserService {

  /**
   * This method is responsible to,
   *  - fetch user profile from okta.
   *  - Map to custom User object. (Note: Be cautious while user User object, cause there are lot of classes with same name from different libraries)
   * @return
   * @throws IOException
   */
  @Override
  public User getUser() throws IOException {

    ObjectMapper objectMapper = new ObjectMapper();

    //Fetching "principal" object from spring security context.
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    //converting object, to json string.
    String pr = objectMapper.writeValueAsString(principal);

    //Converting json string to JsonNode type, to access as key, value pairs.
    JsonNode jsonNode = objectMapper.readTree(pr);

    //Fetching necessary data from json node and saving them to custom local variables.
    String email = jsonNode.get("email").asText();
    String fullName = jsonNode.get("fullName").asText();
    String firstName=jsonNode.get("givenName").asText();
    String lastName=jsonNode.get("familyName").asText();

    //Set user object to return.
    User user = new User();
    user.setEmail(email);
    user.setFullName(fullName);
    user.setFirstName(firstName);
    user.setLastName(lastName);

    return user;
  }
}
