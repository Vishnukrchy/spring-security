package com.db_app.spring_db_security_app.repository;

import com.db_app.spring_db_security_app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmail(String username);

}
