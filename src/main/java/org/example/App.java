package org.example;

import org.example.dao.EmployeeDao;
import org.example.dao.EmployeeDaoImpl;
import org.example.model.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
   {
//        System.out.println( "Hello World!" );
      Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter employee name");
        String name = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        System.out.println("Enter phone");
        String phone = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();

       Employee employee = new Employee(id,name,email,phone,address);

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        int generatedKey = 0;

        try {
            //insert data into the database
            generatedKey = employeeDao.addEmployee(employee);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("generatedKey =" + generatedKey);


       // Update Database
       int updatekey = employeeDao.updateEmployee();
       System.out.println(updatekey);


       //Fetch all the data from database
       List<Employee> emp = employeeDao.getEmployee();
        for(Employee employee2 : emp){
            System.out.println(employee2);
        }


    }

}

