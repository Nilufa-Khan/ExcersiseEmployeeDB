package org.example.dao;

import org.example.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public boolean addEmployee();
    public int updateEmployee();
    public List<Employee> getEmployee();

}
