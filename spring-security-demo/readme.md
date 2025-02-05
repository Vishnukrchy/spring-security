What is Spring Security?

Spring Security is a framework that provides authentication and authorization capabilities for web applications. It is a popular choice for building secure and robust web applications.    
latest version: is spring security 6

What is Authentication and Authorization?
Authentication and authorization are two fundamental concepts in security that ensure that users can access resources only when they are authenticated and have the necessary permissions.
Authentication -> it the process of identifying a user and verifying their identity. its involve validating credentials such as username and password.
Authorization -> it the process of granting or denying access to resources based on the user's identity and permissions.
Example: like when u log in  e commerse site u need to login with username and password to access the site. and u need to be admin to access the admin page.

What is the difference between Authentication and Authorization?
Authentication -> it the process of identifying a user and verifying their identity. its involve validating credentials such as username and password.  
Authorization -> it the process of granting or denying access to resources based on the user's identity and permissions.

what is in memory authentication?
In-memory authentication is a simple authentication method where user credentials are stored in memory. It is often used for testing and development purposes.
 to use it we need to create a class that implements the UserDetailsService interface and override the loadUserByUsername method.

like this:

@Bean
public UserDetailsService userDetailsService() {
UserDetails user1 = User.withUsername("user1")
.password("{noop}password")
.roles("USER")
.build();
UserDetails admin = User.withUsername("admin").
password("{noop}password").
roles("ADMIN").
build();

        // this is for in memory here we are creating 2 users and 1 admin
         // we can create more users

return new InMemoryUserDetailsManager(user1,admin);
}


what is jdbc authentication?
JDBC authentication is a authentication method where user credentials are stored in a database. It is often used for production environments.


What is Role Based Authorization?
Role based authentication is a method of authorization where users are assigned roles that determine what they can access. It is often used for security purposes.
