package org.example.dao;

import org.example.config.DB_Config;
import org.example.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{


    public int addEmployee(Employee employee) throws SQLException, ClassNotFoundException {


            int generatedId = 0;
            Connection connection = DB_Config.getConnection();
            String sql = "insert into employeeeTable (employeeName,employeeEmail,employeePhone,employeeAddress) " +
                    "values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeEmail());
            preparedStatement.setString(3, employee.getEmployeePhone());
            preparedStatement.setString(4, employee.getEmployeeAddress());

            int rows = preparedStatement.executeUpdate();
            if (rows == 1) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    generatedId = resultSet.getInt(1);
                }

            }
            return generatedId;


    }

    public int updateEmployee() {

        int result = 0;
        try {
            Connection connection = DB_Config.getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeUpdate("UPDATE employeeeTable SET employeeName = 'Sagnik', employeeAddress= 'Japan'" +
                    "WHERE emplyoeeId= 1");
            if(result > 0){
                System.out.println("Successfully updated");
            }else{
                System.out.println("Not updated");
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Employee> getEmployee() {
        String query = "SELECT * FROM employeeeTable";
        List<Employee> list = new ArrayList<Employee>();
        Employee employee = null;
        ResultSet rs = null;
        try {
          Connection  connection = DB_Config.getConnection();
           Statement statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                employee = new Employee();
                /*Retrieve one employee details
                and store it in employee object*/
                employee.setEmployeeId(rs.getInt(1));
                employee.setEmployeeName(rs.getString(2));
                employee.setEmployeeEmail(rs.getString(3));
                employee.setEmployeePhone(rs.getString(4));
                employee.setEmployeeAddress((rs.getString(5)));

                //add each employee to the list
                list.add(employee);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
