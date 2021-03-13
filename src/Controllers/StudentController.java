package Controllers;

import Entities.Student;
import Repository.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//Here this controller controls flow of the data between app and repository
public class StudentController {
StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }
    public String logInAsStudent(String accname){
        String response=studentRepository.logInStudent(accname);
        return response;
    }

    public String signInStudent(String name, String surename, String adress,String city, String distinct, String accname, String password){
        boolean response=studentRepository.signAsStudent(new Student(name,surename,adress,city,distinct,accname,password));
        if (response==false){
            return "Something went wrong!";
        }else{
            return "Successfully registrated!";
        }
    }

    public String checkForAccountStudent(String accname){
        String response=studentRepository.searchingForAccnameStudent(accname);
        return response;
    }
}
