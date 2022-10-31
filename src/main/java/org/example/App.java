package org.example;

import org.example.dao.EmployeeDao;
import org.example.dao.EmployeeDaoImpl;
import org.example.model.Employee;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EmployeeDao employeeDao = new EmployeeDaoImpl();
//        employeeDao.addEmployee();
//        employeeDao.updateEmployee();
        List<Employee> emp = employeeDao.getEmployee();
        System.out.println(emp);
    }
}
