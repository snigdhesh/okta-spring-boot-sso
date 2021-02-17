## Overview
This project demonstrates securing spring-boot application with okta SSO (Single Sign On).

## Prerequisites

1. Need to have account on okta. [How to create account on okta?](https://www.youtube.com/watch?v=h_SlnNxJ33s&list=PLlM77U-hjC0xUmbEACVcG---4R040grQi&index=3&t=0s)
2. Register our spring-boot-app on okta. - Make sure to config login redirect URI to `http://localhost:8080/login/oauth2/code/okta` in okta, at **Login redirect URIs**.

## Implementation guideline.

1. Make sure you have all the dependencies from `pom.xml`
2. Add `@EnableOAuth2Client` on main class, `OktaSSOApplication.class`
3. Fetch required user profile from okta, and create a custom `user` object to return. This is implemented in `UserServiceImpl.class`

## How to logout?

We need to logout from two contexts.
1. Spring security context.
2. Okta context.

- To logout from `spring-security context` add `WebSecurityConfig.class` from `config` package. - [source](https://github.com/spring-projects/spring-security/issues/7285)
- To logout from `okta context`, add `okta.oauth2.postLogoutRedirectUri=http://localhost:8080/login/oauth2/code/okta` property in `app config.`
(Make sure to configure, the same redirect URI on okta at **Logout redirect URIs**) 
- After adding the above steps, hit `/logout` end point directly, this doesn't need any extra config.


**For story lovers**  
This is a special scenario, cause `okta SDK` will not provide any functionality to logout for now.
Ideally, just hitting `/logout` end point will logout the session by spring security (but okta session is still mantained).

But I faced issue here, `spring-security` displays successful logout page, but actually it doesn't logout and still maintains session.
This can be tested by removing `okta.oauth2.post-logout-redirect-uri=http://localhost:8080/` property from application config,
and hitting `/logout` end point.

