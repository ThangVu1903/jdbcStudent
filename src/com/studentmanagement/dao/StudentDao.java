package com.studentmanagement.dao;

import com.studentmanagement.enlity.Student;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private Connection conn;
    public static List<Student> studentList = new ArrayList<>();
    public Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "19032002az");
            return conn;
        }
        return conn;
    }

    public  void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public Student findById(int id) throws SQLException {

        String query = "SELECT * FROM Student WHERE id = "+ id;
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            Student student = new Student(resultSet);
            return student;
        } else {
            return null;
        }

    }
    public List<Student> findAll() throws SQLException {
        String query = "SELECT * FROM Student";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Student student = new Student(resultSet);
            studentList.add(student);
        }
        return studentList;
    }

    public boolean addStudent(Student student) throws SQLException {
        String dob = student.getDob().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String query = "insert into student(id,first_name,last_name,city,average_score,gender,dob) values ("
                + student.getID() + ",'" + student.getFirstName() + "', '" + student.getLastName() + "', '" +
                student.getCity() + "', " + student.getAverageScore() + ", '" + student.getGender() + "', '" +
                dob + "')";
        Statement statement = getConnection().createStatement();
        int result = statement.executeUpdate(query);
        if(result != 0) {
            System.out.println("Add Student successfully");
            return true;
        }
        return false;
    }

    public boolean deleteById(int id) throws SQLException{
        String query = "DELETE FROM Student WHERE id = " + id;
        Statement statement = getConnection().createStatement();
        int resultSet = statement.executeUpdate(query);
        if(resultSet != 0){
            System.out.println("delete successfully");
            return true;
        }
        return false;
    }

    public boolean updateName(Student student) throws SQLException{
        String query = "UPDATE Student SET first_name='"+student.getFirstName()+
                "' and last_name='"+student.getLastName()+"' WHERE ID = "+student.getID();
        Statement statement = getConnection().createStatement();
        int result = statement.executeUpdate(query);
        if(result != 0) {
            System.out.println("update Student name successfully");
            return true;
        }
        return false;
    }

    public boolean updateScore(Student student) throws SQLException{
        String query = "UPDATE Student SET average_score="+student.getAverageScore();
        Statement statement = getConnection().createStatement();
        int result = statement.executeUpdate(query);
        if(result != 0 ){
            System.out.println("update Student average score successfully*_*");
            return true;
        }
        return false;
    }


}









