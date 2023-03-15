package com.cg.module03casestudy.service.impl;
import com.cg.module03casestudy.connection.JdbcConnection;
import com.cg.module03casestudy.model.Student;
import com.cg.module03casestudy.service.StudentService;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private List<Student> students;
    @Override
    public List<Student> findAll() {
        students = new ArrayList<>();

        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * FROM sinhvien5";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setStuID(resultSet.getInt("stuID"));
                student.setNamestu(resultSet.getString("namestu"));
                student.setDateofbirth(resultSet.getString("dateofbirth"));

                student.setEmail(resultSet.getString("email"));
                student.setAddress(resultSet.getString("address"));

                students.add(student);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }



    @Override
    public void save(Student student) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "INSERT INTO sinhvien5( namestu,dateofbirth,email,address) " +
                    "VALUES(?, ? ,? ,? , ?  )";
            PreparedStatement preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(2, student.getNamestu());
            preparedStatement.setString(3, student.getDateofbirth());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getAddress());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Added user successfully!");
            } else {
                System.out.println("Added user failed!");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student findById(int stuID) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * FROM sinhvien5 WHERE stuID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stuID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setStuID(resultSet.getInt("stuID"));
                student.setNamestu(resultSet.getString("namestu"));
                student.setDateofbirth(resultSet.getString("dateofbirth"));
                student.setEmail(resultSet.getString("email"));
                student.setAddress(resultSet.getString("address"));

                return student;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void update(int stuID, Student student) {

        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "UPDATE sinhvien5 SET namestu = ?, dateofbirth= ?, email = ?, address = ?, WHERE stuID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString( 1,student.getNamestu());
            preparedStatement.setString(2, student.getDateofbirth());
            preparedStatement.setString( 3,student.getEmail());
            preparedStatement.setString( 4,student.getAddress());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Updated role id [" + student.getStuID() + "] successfully!");
            } else {
                System.out.println("Updated role id [" + student.getStuID() + "] failed!");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int stuID) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "DELETE FROM sinhvien5 WHERE stuID= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stuID);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Removed user id [" + stuID+ "] successfully!");
            } else {
                System.out.println("Removed user id [" + stuID + "] failed!");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
