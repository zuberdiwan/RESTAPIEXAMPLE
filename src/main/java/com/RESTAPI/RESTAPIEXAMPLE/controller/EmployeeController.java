package com.RESTAPI.RESTAPIEXAMPLE.controller;

import com.RESTAPI.RESTAPIEXAMPLE.model.Employee;
import com.RESTAPI.RESTAPIEXAMPLE.services.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployeeData(@RequestBody @Valid Employee employee){
        return  new ResponseEntity<Employee>(employeeService.employeeSave(employee),HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> GetAllEmployees(){
        return  employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){


        return  new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("{empId}")
    public  ResponseEntity<Employee> updateEmployeeData(@PathVariable("empId") long empId,@RequestBody Employee employee){

        return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee,empId),HttpStatus.OK);
    }

    @DeleteMapping("{empId}")
    public  ResponseEntity<String> deleteEmployeeById(@PathVariable("empId") long empId){
        employeeService.EmployeeDelete(empId);
        return  new ResponseEntity<String>("Employee Deleted Succesfully",HttpStatus.OK);
    }


}
