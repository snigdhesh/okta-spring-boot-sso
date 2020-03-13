package com.home.okta.sso.controllers;

import com.home.okta.sso.models.User;
import com.home.okta.sso.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;

@RestController
public class UserController {

  @Qualifier("user")
  @Autowired
  private IUserService userService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Principal getPrincipal(Principal principal) {
    return principal;
  }

  @RequestMapping(value = "/principal", method = RequestMethod.GET)
  public Object getAuthentication(Authentication authentication) {
    return authentication.getPrincipal();
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public User getUser() throws IOException {
    return userService.getUser();
  }

}
