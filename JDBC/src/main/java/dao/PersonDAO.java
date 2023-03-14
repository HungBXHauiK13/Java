package dao;

import connection.MyConnection;
import model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    public List<Person> getAll() {
        // Bươc 1: Tạo kết nối

        // Bước 2: Chuẩn bị câu lệnh

        // Bước 3: Thực thi và xem kết quả

        // Bước 4: Đóng kết nối
        List<Person> list = new ArrayList<>();
        try {
//            buoc 1
            Connection connection = MyConnection.getConnection();
//            buoc 2
            String sql = "SELECT * FROM persons";
//            buoc 3
            Statement statement = connection.createStatement(); // phương thức thực thi truy vấn vs sql
            ResultSet resultSet = statement.executeQuery(sql); // duy trì một con trỏ trỏ đến một hàng của một bảng
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setName(resultSet.getString("fullName"));
                person.setAddress(resultSet.getString("address"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));
                list.add(person);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Person getById(Long id){
        try {
            Connection connection = MyConnection.getConnection();
            String sql = "Select * from `persons` where `id` = " + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Person p = null;
            if (rs.next()) {
                p = new Person();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("fullName"));
                p.setAddress(rs.getString("address"));
                p.setEmail(rs.getString("email"));
                p.setPhone(rs.getString("phone"));
            }
            rs.close();
            statement.close();
            connection.close();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insert(Person person){
        // Bươc 1: Tạo kết nối

        // Bước 2: Chuẩn bị câu lệnh

        // Bước 3: Thực thi và xem kết quả

        // Bước 4: Đóng kết nối
        try {
            Connection connection = MyConnection.getConnection();
            String sql = String.format("INSERT INTO `persons` (`fullName`,`address`,`phone`,`email`) VALUES ('%s','%s','%s','%s') ",
                    person.getName(), person.getAddress(), person.getPhone(), person.getEmail()
            );
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Person update(Person p, long id) {
        try {
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
