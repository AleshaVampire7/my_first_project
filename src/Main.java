import Applications.InstructorApplication;
import Applications.MainApplication;
import Applications.StudentApplication;
import Controllers.GradeController;
import Controllers.InstructorController;
import Controllers.StudentController;
import DatabaseController.DBManager;
import Repository.GradeRepository;
import Repository.GradeRepositoryUpdated;
import Repository.InstructorRepository;
import Repository.StudentRepository;
import Validator.Validator;
//Here we created a lot of constructors to work with methods that are needed. Also we calling method that is in the main app
public class Main {
    public static void main(String[] args) {
        DBManager dbManager=new DBManager();
        InstructorRepository instructorRepository=new InstructorRepository(dbManager);
        StudentRepository studentRepository=new StudentRepository(dbManager);
        GradeRepository gradeRepository=new GradeRepository(dbManager);
        GradeRepositoryUpdated gradeRepositoryUpdated=new GradeRepositoryUpdated(dbManager);
        GradeController gradeController=new GradeController(gradeRepository,gradeRepositoryUpdated);
        InstructorController instructorController=new InstructorController(instructorRepository);
        StudentController studentController=new StudentController(studentRepository);
        Validator validator=new Validator();
        InstructorApplication instructorApplication=new InstructorApplication(gradeController,studentController,instructorController,validator);
        StudentApplication studentApplication=new StudentApplication(gradeController,studentController,instructorController,validator);
        MainApplication mainApplication=new MainApplication(gradeController,studentController,instructorController,validator,instructorApplication,studentApplication);
        mainApplication.start();



    }
}
