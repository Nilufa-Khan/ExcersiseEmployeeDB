package org.example.dao;

import org.example.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    public int addEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    public int updateEmployee();
    public List<Employee> getEmployee();

}
