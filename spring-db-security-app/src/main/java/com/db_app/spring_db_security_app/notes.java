package com.db_app.spring_db_security_app;
/*
Steps to Implement Authentication in Spring Security

CustomUser Class:

Implements the Userdetails interface to represent the authenticated user.
CustomUserDetailsService Class:

Implements the UserDetailsService interface.
Responsible for loading user-specific data during the authentication process.
SecurityConfig Class:

Configure the security settings using the following steps:
Create BCryptPasswordEncoder Bean: To hash passwords securely.
Create DaoProvider Bean: Inject the UserDetails object and PasswordEncoder.
Configure the SecurityFilter Chain: Define the filters for authentication and authorization.
Authentication Flow Diagram

UsernamePasswordAuthToken:

Entry point where user credentials are passed for authentication.
AuthenticationManager:

Manages the authentication process. Delegates to a specific provider.
Provider (DaoAuthenticationProvider):

Authenticates using user data from the database.
Dependencies:
UserDetailsService: Loads user-specific data.
PasswordEncoder: Encodes and verifies passwords.
UserDetailsService:

Retrieves the user details (UserDetails) from the database.
PasswordEncoder:

Verifies if the provided password matches the encoded one.
Components

AuthenticationManager: Central point for managing the authentication process.
Provider (DaoAuthenticationProvider): Delegates authentication tasks to UserDetailsService and PasswordEncoder.
UserDetailsService: Retrieves user information like username and password.
PasswordEncoder: Used for encoding and verifying passwords.

 */