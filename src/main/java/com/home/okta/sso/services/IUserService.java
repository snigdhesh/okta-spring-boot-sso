package com.home.okta.sso.services;

import com.home.okta.sso.models.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface IUserService {
  public User getUser() throws IOException;
}
