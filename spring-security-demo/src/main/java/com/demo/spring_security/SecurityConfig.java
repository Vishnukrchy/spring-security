package com.demo.spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


//    @Bean
//    SecurityFilterChain  defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//      http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
//      http.sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//    //  http.formLogin(withDefaults());
//      http.httpBasic(withDefaults());
//
//      return http.build();
//
//    }

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.withUsername("user1")
//                .password("{noop}password1")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin").
//                password("{noop}adminPass").
//                roles("ADMIN").
//                build();\

        UserDetails user1 = User.withUsername("user1").password(passwordEncoder().encode("password1")).roles("USER").build();
        UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN").build();

        // this is for in memory here we are creating 2 users and 1 admin
         // we can create more users
        return new InMemoryUserDetailsManager(user1,admin);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(Customizer.withDefaults());
        http.sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        http.httpBasic(withDefaults());
        return http.build();
    }


}
