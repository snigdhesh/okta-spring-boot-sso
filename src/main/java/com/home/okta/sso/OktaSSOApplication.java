package com.home.okta.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
//  (exclude = {SecurityAutoConfiguration.class,ManagementWebSecurityAutoConfiguration.class})
//@EnableOAuth2Sso //To enable OKTA SSO, somehow this annotation fails to work.
@EnableOAuth2Client
public class OktaSSOApplication {

  public static void main(String[] args) {
    SpringApplication.run(OktaSSOApplication.class, args);
  }

}
