package com.db_app.spring_db_security_app.config;

import com.db_app.spring_db_security_app.model.Employee;
import com.db_app.spring_db_security_app.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomUserDetailsService implements UserDetailsService {

      public CustomUserDetailsService(){

     }
    @Autowired
    private EmployeeRepository employeeRepository;



    /*
    loadUserByUsername method is used to load user details from the database. its typically used to authenticate users.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Employee emp = employeeRepository.findByEmail(username);

       if (emp == null) {
           throw new UsernameNotFoundException("User not found");
       }else {
         log.atInfo().log("User {} found", username);
         new CustomUser(emp);
       }
       return new CustomUser(emp);

    }
}
