package Controllers;

import Entities.Instructor;
import Entities.Student;
import Repository.InstructorRepository;

import java.util.List;
//Here this controller controls flow of the data between app and repository
public class InstructorController {
    InstructorRepository instructorRepository;
public InstructorController(InstructorRepository instructorRepository){
    this.instructorRepository=instructorRepository;
}


public String logInAsInstructor(String accname){
        String response=instructorRepository.logInInstructor(accname);
        return response;
}

public boolean signInAsInstructor(String name, String surename, int age, String rank, String city, String accname, String password){
        boolean response=instructorRepository.signInInstructor(new Instructor(name,surename,age,rank,city,accname,password));
        return response;
}

    public String checkForAccountInstructor(String accname){
        String response=instructorRepository.searchingForAccnameInstructor(accname);
        return response;
}

public String getAllStudents(){
    List <Student> students=instructorRepository.getAllStudents();
    if(students==null){
        return "No students currently!";
    }else {
        return students.toString();
    }

}

public String searchStudentByName(String name){
    List <Student> students=instructorRepository.searchStudentByName(name);
    if (students==null){
        return "We don't have such students!";
    }else{
        return students.toString();
    }
}

public String getStudentById(int id){
    Student response=instructorRepository.getStudentById(id);
    if (response==null){
        return "We don't have such a student";
    }else{
        return response.toString();
    }
}

public String addStudent(String name, String surename, String adress, String city, String distinct,String accname,String password){
    boolean result=instructorRepository.addStudent(new Student(name,surename,adress,city,distinct,accname,password));
    if (result){
        return "You've been succesfully registered!";
    }else {
        return "Something went wrong!";
    }
}

public String removeStudentById(int id){
    boolean result=instructorRepository.removeStudentById(id);
    if (result){
        return "Student was deleted!";
    }else {
        return "Student was not deleted!";
    }
}


}
