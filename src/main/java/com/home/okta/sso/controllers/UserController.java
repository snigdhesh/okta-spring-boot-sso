package com.home.okta.sso.controllers;

import com.home.okta.sso.models.User;
import com.home.okta.sso.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@RestController
public class UserController {

  @Qualifier("user")
  @Autowired
  private IUserService userService;

  /**
   * This method fetches parent object - which means it fetches whole okta profile with different children profiles. (Including user information)
   *
   * @param principal
   * @return
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Principal getPrincipal(Principal principal) {
    return principal;
  }

  /**
   * This method fetches one child profile (called principal) out of parent profile. - This will have user information.
   *
   * @param authentication
   * @return
   */
  @RequestMapping(value = "/principal", method = RequestMethod.GET)
  public Object getAuthentication(Authentication authentication) {
    return authentication.getPrincipal();
  }

  /**
   * This method is responsible to fetch required attributes from user profile and return it.
   *
   * @return
   * @throws IOException
   */
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public User getUser() throws IOException {
    return userService.getUser();
  }

  @RequestMapping(value="/logout",method = RequestMethod.POST)
  public void logout(HttpSecurity httpSecurity) throws Exception {
    System.out.println("Logged out");
    //httpSecurity.logout(i->i.logoutSuccessUrl("/").permitAll());

  }

}
