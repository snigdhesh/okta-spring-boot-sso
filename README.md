## Overview
This project demonstrates securing spring-boot application with okta SSO (Single Sign On).

## Prerequisites

1. Need to have account on okta. [How to create account on okta?](https://www.youtube.com/watch?v=h_SlnNxJ33s&list=PLlM77U-hjC0xUmbEACVcG---4R040grQi&index=3&t=0s)
2. Register our spring-boot-app on okta.

## Implementation guideline.

1. Make sure you have all the dependencies from `pom.xml`
2. Add `@EnableOAuth2Client` on main class, `OktaSSOApplication.class`
3. Fetch required user profile from okta, and create a custom `user` object to return. This is implemented in `UserServiceImpl.class`
