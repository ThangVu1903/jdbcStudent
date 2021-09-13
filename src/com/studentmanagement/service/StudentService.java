package com.studentmanagement.service;

import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.enlity.Student;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static javax.swing.UIManager.getString;

public class StudentService {

    private StudentDao studentDao = new StudentDao();
    private Scanner scanner = new Scanner(System.in);

    public void findById() {
        try {
            System.out.println("Search By id");
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Student student = studentDao.findById(id);
            System.out.println(student);
        } catch (InputMismatchException e ){
            System.out.println("Enter the wrong, re-enter(ID type int)");
        }catch (SQLException sqlException) {
            System.out.println("sql exception");
        } finally {
            studentDao.closeConnection();
        }

    }

    public void findAll() {
        try {
            System.out.println("Find all");
            List<Student> students = studentDao.findAll();
            if (students.isEmpty()) {
                System.out.println("List is empty");
            }
            for (Student student: students) {
                System.out.println(student);
            }
        } catch (SQLException sqlException) {
            System.out.println("sql exception");
        }
    }

     public void addStudent(){
        try{
            Student student = new Student();
            System.out.println("Enter student information: ");
            System.out.println("ID: ");
            int ID = scanner.nextInt();
            scanner.nextLine();
            student.setID(ID);
            System.out.println("first name :");
            String firstName = scanner.nextLine();
            student.setFirstName(firstName);
            System.out.println("last name: ");
            String lastName = scanner.nextLine();
            student.setLastName(lastName);
            System.out.println("city:");
            String city = scanner.nextLine();
            student.setCity(city);
            System.out.println(" average score : ");
            double averageScore= scanner.nextDouble();
            scanner.nextLine();
            student.setAverageScore(averageScore);
            System.out.println("gender : ");
            char gender = scanner.nextLine().charAt(0);
            student.setGender(gender);
            System.out.println("day of birth: ");
            String dob = scanner.nextLine();
            LocalDate date = LocalDate.parse(dob,DateTimeFormatter.ISO_LOCAL_DATE);
            student.setDob(date);
            studentDao.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
    public void deleteStudentById() {
        try {
            System.out.println("enter ID need delete :");
            int idDelete = scanner.nextInt();
            scanner.nextLine();
            studentDao.deleteById(idDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modifyNameStudent(){
        try{
            System.out.println("enter id need update");
            int idUpdateName = scanner.nextInt();
            scanner.nextLine();
            Student student = studentDao.findById(idUpdateName);
            if (student==null){
                System.out.println("not fount student!");
                return;
            }
            System.out.println("enter new first name: ");
            String newFirstName = scanner.nextLine();
            student.setFirstName(newFirstName);
            System.out.println("enter new last name : ");
            String newLastName= scanner.nextLine();
            student.setLastName(newLastName);
            studentDao.updateName(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateStudentScore(){
        try{
            System.out.println("enter id need update score");
            int idUpdateScore = scanner.nextInt();
            scanner.nextLine();
            Student student=studentDao.findById(idUpdateScore);
            if(student==null){
                System.out.println("not fount student");
                return;
            }
            System.out.println("enter new score : ");
            double newScore = scanner.nextDouble();
            student.setAverageScore(newScore);
            studentDao.updateScore(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}