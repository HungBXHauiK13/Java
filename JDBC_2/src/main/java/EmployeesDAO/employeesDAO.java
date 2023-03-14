package EmployeesDAO;

import Connection.MyConnection;
import Employees.Employees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class employeesDAO {
    public void insertNewE(Employees e1){
        try {
            // Bươc 1: Tạo kết nối
            Connection connection = MyConnection.getConnection();
            // Bước 2: Chuẩn bị câu lệnh
            String sql = String.format("insert into `employees` (`full_name`,`city`,`email`,`phone`,`gender`,`salary`) Values ('%s','%s','%s','%s','%s','%s')",
                e1.getFull_name(), e1.getCity(), e1.getEmail(), e1.getPhone(), e1.getGender(), e1.getSalary()
            );
            // Bước 3: Thực thi và xem kết quả
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Employees> getEmployees(){
        List<Employees> employeesList = new ArrayList<>();
        try {
            Connection connection = MyConnection.getConnection();
            String sql = "select * from employees";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employees e1 = new Employees();
                e1.setId(resultSet.getInt("id"));
                e1.setFull_name(resultSet.getString("full_name"));
                e1.setCity(resultSet.getString("city"));
                e1.setEmail(resultSet.getString("email"));
                e1.setPhone(resultSet.getString("phone"));
                e1.setGender(resultSet.getInt("gender"));
                e1.setSalary(resultSet.getInt("salary"));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return employeesList;
    }
}
