package com.studentmanagement.app;

import com.studentmanagement.service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final StudentService studentService = new StudentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome Student management system!");
        showMenu();
        while(true) {
            System.out.println("Enter funtions");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    studentService.findAll();
                    break;
                case 2:
                   studentService.addStudent();
                    break;
                case 3:
                    studentService.deleteStudentById();
                    break;
                case 4:
                    studentService.modifyNameStudent();
                    break;
                case 5:
                    studentService.findById();
                    break;
                case 6:
                    showMenu();
                    break;
                case 7:
                    studentService.findStudentByCity();
                    break;
                case 8:
                   studentService.updateStudentScore();
                    break;
                case 9:
                   studentService.modifyDobById();
                    break;
                case 10:
                    studentService.findAverageMax();
                    break;
                case 11:
                    studentService.updateAllStudentScore();
                    break;
                case 12:
                    System.out.println("Good bye.");
                    return;
                default:
                    System.out.println("Not a option. Please choose again");
            }
        }
    }

    public static void showMenu() {
        System.out.println("1. List Student");
        System.out.println("2. Add Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Update student name");
        System.out.println("5. Search student By Id");
        System.out.println("6. Show menu");
        System.out.println("7. List Students By city");
        System.out.println("8. update score student by id");
		System.out.println("9. update date of birth by id");
		System.out.println("10. find Student is averageScore max");
		System.out.println("11. update all average score of student");
        System.out.println("12. Exist");

    }
}