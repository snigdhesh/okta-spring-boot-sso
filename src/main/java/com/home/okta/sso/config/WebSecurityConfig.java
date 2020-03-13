package com.home.okta.sso.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * Source: https://github.com/spring-projects/spring-security/issues/7285
 * <p>
 * This class mainly focuses on logging out session. Without this class even though okta logs out,
 * we are unable to redirect to desired page.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

  @Autowired
  private ClientRegistrationRepository clientRegistrationRepository;

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    LogoutSuccessHandler logoutHandler = new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);
    http
      .csrf().disable()
      .authorizeRequests().anyRequest().authenticated()
      .and()
      .logout()
      //.logoutSuccessUrl("xxxx");
      .logoutSuccessHandler(logoutHandler);
  }
}
