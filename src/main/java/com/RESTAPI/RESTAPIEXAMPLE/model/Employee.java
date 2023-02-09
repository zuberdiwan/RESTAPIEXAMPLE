package com.RESTAPI.RESTAPIEXAMPLE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee_Tbl")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long empId;
    private  String empName;
    private  String empSirname;
    private  String empCity;
    private  String empEmail;
    private  double empsalary;

    public Employee(long empId, String empName, String empSirname, String empCity, String empEmail, double empsalary) {
        this.empId = empId;
        this.empName = empName;
        this.empSirname = empSirname;
        this.empCity = empCity;
        this.empEmail = empEmail;
        this.empsalary = empsalary;
    }

    public Employee() {

    }
    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSirname() {
        return empSirname;
    }

    public void setEmpSirname(String empSirname) {
        this.empSirname = empSirname;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public double getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(double empsalary) {
        this.empsalary = empsalary;
    }


}
