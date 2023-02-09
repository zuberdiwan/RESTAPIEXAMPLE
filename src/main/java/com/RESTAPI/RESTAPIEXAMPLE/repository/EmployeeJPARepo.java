package com.RESTAPI.RESTAPIEXAMPLE.repository;

import com.RESTAPI.RESTAPIEXAMPLE.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJPARepo extends JpaRepository<Employee, Long> {

}
