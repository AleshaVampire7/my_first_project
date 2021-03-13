package Applications;

import Controllers.GradeController;
import Controllers.InstructorController;
import Controllers.StudentController;
import Validator.Validator;

import java.util.Scanner;
//I called this class main because of functions. Here you decide what to do.
public class MainApplication {
    protected int option;
    protected  int option2;//created some parameters
    public Scanner scanner;
    Validator validator;
    GradeController gradeController;
    StudentController studentController;
    InstructorController instructorController;
    InstructorApplication instructorApplication;
    StudentApplication studentApplication;
    public MainApplication(GradeController gradeController, StudentController studentController, InstructorController instructorController,Validator validator,InstructorApplication instructorApplication,StudentApplication studentApplication){
        this.gradeController=gradeController;
        this.instructorController=instructorController;
        this.studentController=studentController;
        this.instructorApplication=instructorApplication;
        this.studentApplication=studentApplication;
    }


    public void start(){
        System.out.println("Welcome to our app that was dedicated for University!");
        scanner=new Scanner(System.in);

        while(true){
            System.out.println("Enter the option that you need!");
            System.out.println("1)Sign In \n2)Log in \n3)Quit");
            option=scanner.nextInt();
            if (option==1){
                System.out.println("Enter the second option that you need!");
                System.out.println("1)Sign in as student\n2)Sign in as instructor");
                option2=scanner.nextInt();

                if (option2==1){
                    studentApplication.signInStudentMenu();
                }else if (option2==2){
                    instructorApplication.signInInstructorMenu();
                }
            }
            else if (option==2){
                System.out.println("Enter the second option that you need!");
                System.out.println("1)Log in as student\n2)Log in as instructor");
                option2=scanner.nextInt();
                if (option2==1){
                    studentApplication.logInStudentMenu();
                }
                else if (option2==2){
                    instructorApplication.logInInstructorMenu();
                }
                System.out.println("======================================");
            }
        }
    }
}
