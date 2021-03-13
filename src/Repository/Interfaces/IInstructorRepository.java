package Repository.Interfaces;

import Entities.Instructor;
import Entities.Student;

import java.util.ArrayList;
import java.util.List;
//Here we stored methods that have to be in implementing class.
public interface IInstructorRepository {
    public  boolean signInInstructor(Instructor instructor);
    public  String logInInstructor(String accname);
    public String searchingForAccnameInstructor(String accname);
    public List<Student> getAllStudents();
    public List<Student> searchStudentByName(String name);
    public Student getStudentById(int id);
    public boolean addStudent(Student student);
    public boolean removeStudentById(int id);
}
