package com.isett.lab2.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Student {

    @NotBlank(message = "Please enter the student's name")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Please enter an email address")
    @Email(message = "Invalid email format. Example: example@domain.com")
    private String email;

    @NotBlank(message = "Please specify the student's major")
    private String major;

    // Default constructor
    public Student() {
    }

    public Student(String name, String email, String major) {
        this.name = name;
        this.email = email;
        this.major = major;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
