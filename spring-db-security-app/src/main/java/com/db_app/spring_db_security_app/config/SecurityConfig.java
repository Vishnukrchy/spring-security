package com.db_app.spring_db_security_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    public UserDetailsService getUserDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        /*
         * http.csrf().disable()
         * .authorizeHttpRequests().requestMatchers("/","/register","/signin",
         * "/saveUser").permitAll() .requestMatchers("/user/**").authenticated().and()
         * .formLogin().loginPage("/signin").loginProcessingUrl("/userLogin")
         * //.usernameParameter("email")
         * .defaultSuccessUrl("/user/profile").permitAll();
         */
        http.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/**").permitAll().and()
                .formLogin().loginPage("/signin").loginProcessingUrl("/userLogin")
                .successHandler(sucessHandler)
                .permitAll();


        return http.build();
    }
}
