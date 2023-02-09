package com.RESTAPI.RESTAPIEXAMPLE.services;

import com.RESTAPI.RESTAPIEXAMPLE.exception.ResourceNotFoundException;
import com.RESTAPI.RESTAPIEXAMPLE.model.Employee;
import com.RESTAPI.RESTAPIEXAMPLE.repository.EmployeeJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterf{
    @Autowired
    private EmployeeJPARepo employeeJPARepo;
    @Override
    public Employee employeeSave(Employee employee) {
        return employeeJPARepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeJPARepo.findAll();
    }

    @Override
    public Employee getEmployeeById(long empId) {
        Optional<Employee> employee=employeeJPARepo.findById(empId);
        if (employee.isPresent()){
            return  employee.get();
        }else {
            throw  new ResourceNotFoundException("Employee","Id",empId);
        }

        //return employeeJPARepo.findById(empid).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",empid));
    }

    @Override
    public Employee updateEmployee(Employee employee, long empId) {
        //Find Employee present or not
        Employee employeePresent =employeeJPARepo.findById(empId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","Id",empId)
        );

        employeePresent.setEmpName(employee.getEmpName());
        employeePresent.setEmpSirname(employee.getEmpSirname());
        employeePresent.setEmpCity(employee.getEmpCity());
        employeePresent.setEmpEmail(employee.getEmpEmail());
        employeePresent.setEmpsalary(employee.getEmpsalary());

        employeeJPARepo.save(employeePresent);
        return employeePresent;
    }

    @Override
    public void EmployeeDelete(long empId) {
        //first check employee exist or not
        employeeJPARepo.findById(empId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","Id",empId)
        );
        employeeJPARepo.deleteById(empId);
    }
}
