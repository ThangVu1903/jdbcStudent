package com.studentmanagement.enlity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Student {

    private int ID;
    private String lastName;
    private String firstName;
    private String city;
    private double averageScore;
    private char gender;
    private LocalDate dob;

    public Student() {
    }
    public Student(ResultSet resultSet) throws SQLException {
        this.ID = resultSet.getInt("ID");
        this.lastName = resultSet.getString("last_name");
        this.firstName = resultSet.getString("first_name");
        this.city = resultSet.getString("city");
        this.averageScore = resultSet.getDouble("average_score");
        this.gender = resultSet.getString("gender").charAt(0);
        String dobString = resultSet.getString("dob");
        LocalDate dob = LocalDate.parse(dobString, DateTimeFormatter.ISO_LOCAL_DATE);
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return ID == student.ID && Double.compare(student.averageScore, averageScore) == 0 && gender == student.gender && Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) && Objects.equals(city, student.city) && Objects.equals(dob, student.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, lastName, firstName, city, averageScore, gender, dob);
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student[" +
                "ID=" + ID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", city='" + city + '\'' +
                ", avergaeScore=" + averageScore +
                ", gender=" + gender +
                ", dob=" + dob +
                ']';
    }
}
