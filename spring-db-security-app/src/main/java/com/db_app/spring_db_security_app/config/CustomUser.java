package com.db_app.spring_db_security_app.config;

import com.db_app.spring_db_security_app.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomUser implements UserDetails {

    private Employee emp;


    CustomUser(Employee emp) {
        this.emp=emp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // SimpleGrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+emp.getRole());
         // SimpleGrantedAuthority is a predefined class that used to create authority object for role
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(emp.getRole());
        //return the authority in the form of list
        return Arrays.asList(authority);

    }

    @Override
    public String getPassword() {
        return emp.getPassword();
    }

    @Override
    public String getUsername() {
        return emp.getEmail();
    }
}
