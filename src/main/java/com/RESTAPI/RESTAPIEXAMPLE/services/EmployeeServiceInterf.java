package com.RESTAPI.RESTAPIEXAMPLE.services;

import com.RESTAPI.RESTAPIEXAMPLE.model.Employee;

import java.util.List;

public interface EmployeeServiceInterf {
    Employee employeeSave(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long empId);
    Employee updateEmployee(Employee employee,long empId);

    void EmployeeDelete(long empId);
}
