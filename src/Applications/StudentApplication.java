package Applications;

import Controllers.GradeController;
import Controllers.InstructorController;
import Controllers.StudentController;
import Validator.Validator;

import java.util.Scanner;
//Here as you can see we have another one app for students. Methods were dedicated only for students
public class StudentApplication {
    protected Scanner scanner=new Scanner(System.in);
    Validator validator;
    GradeController gradeController;
    StudentController studentController;
    InstructorController instructorController;
    public StudentApplication(GradeController gradeController, StudentController studentController, InstructorController instructorController,Validator validator){
        this.gradeController=gradeController;
        this.instructorController=instructorController;
        this.studentController=studentController;
        this.validator=validator;
    }
    public void signInStudentMenu() {
        System.out.println("========================");
        boolean checkpassword = false;
        String password = "000";
        String name=null;
        while (name==null){
            System.out.println("Write your name:");
            name = scanner.next();
        }
        String surname=null;
        while (surname==null){
            System.out.println("Write your surname:");
            surname = scanner.next();
        }

        System.out.println("Write your address:");
        String adress = scanner.nextLine();
        adress = scanner.nextLine();
        System.out.println("Enter your City:");
        String city = scanner.next();
        System.out.println("Write your distinct:");
        String distinct = scanner.next();
        String accname;
        while (true) {
            System.out.println("Enter your account name:");
            accname = scanner.next();
            if (studentController.checkForAccountStudent(accname) == null) {
                break;
            } else {
                System.out.println("We hava such a User!");
                continue;
            }
        }
        System.out.println("Enter your password for your account:");

        while (true){
            System.out.println("Password must to contain at least \n1 uppercase letter, \n1 lowercase letter, \n1 digit, \n1 special symbol(@,$).");
            password=scanner.nextLine();
            if(validator.checkPassword(password)==true){
                break;
            }else{
                continue;
            }
        }
        String result=studentController.signInStudent(name,surname,adress,city,distinct,accname,password);

        System.out.println(result);
    }

    public void logInStudentMenu (){
        System.out.println("========================");
        String accname=null;
        boolean checkpassword;
        String password;
        String course;
        int i;
        checkpassword=false;
        String realPassword=null;
        System.out.println("Enter your account name:");
        while (realPassword==null){
            accname=scanner.next();
            realPassword=studentController.logInAsStudent(accname);
            if (realPassword!=null){
                break;
            }else {
                System.out.println("Wrong account name, Enter again:");
                continue;
            }
        }
        System.out.println("Enter password:");
        password=scanner.next();

        while(checkpassword==false){

            checkpassword =validator.checkPasswordLogIn(password,realPassword);

            if (checkpassword==true){
                break;
            }else{
                System.out.println("Wrong password! TRY AGAIN!");
                password=scanner.next();
            }
        }
        System.out.println("You entered!");
        while (true){
            System.out.println("Enter option3:");
            System.out.println("1)Get all grades \n2)Get grades by course\n0)Quit");
            i=scanner.nextInt();
            String response=null;
            if (i==0){
                break;
            }else if(i==1) {
                getAllGradesStudent();
            }else if(i==2){
                getGradesbyCourseStudent();
            }
            else{
                System.out.println("We don't have such an option!");
            }

        }
    }
    public void getAllGradesStudent(){
        String result=gradeController.getAllGrades();
        System.out.println(result);
    }
    public void getGradesbyCourseStudent(){
        System.out.println("Enter course name:");
        String course=scanner.next();
        String result= gradeController.seeGradeByCourse(course);
        System.out.println(result);
    }


}
