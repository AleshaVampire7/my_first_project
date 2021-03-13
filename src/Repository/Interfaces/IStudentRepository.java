package Repository.Interfaces;

import Entities.Student;
//Here we stored methods that have to be in implementing class.
public interface IStudentRepository {
    public  boolean signAsStudent(Student student);
    public  String logInStudent(String accname);
    public String searchingForAccnameStudent(String accname);

}
