package Applications;

import Controllers.GradeController;
import Controllers.InstructorController;
import Controllers.StudentController;
import Validator.Validator;

import java.util.Scanner;
//Here as you can see we have all methods. And they are connected with Instructor application. Exactly, action that instructor able to do.
public class InstructorApplication {
    public Scanner sc=new Scanner(System.in);
    Validator validator;
    GradeController gradeController;
    StudentController studentController;
    InstructorController instructorController;
    public InstructorApplication(GradeController gradeController, StudentController studentController, InstructorController instructorController,Validator validator){
        this.gradeController=gradeController;
        this.instructorController=instructorController;
        this.studentController=studentController;
        this.validator=validator;
    }

    public void signInInstructorMenu() {

        boolean checkpassword = false;
        String password = "000";
        System.out.println("Write your name:");
        String name = sc.next();
        System.out.println("Write your surname:");
        String surename = sc.next();
        System.out.println("Write your age:");
        int age = sc.nextInt();
        System.out.println("Enter your rank:");
        String rank = sc.nextLine();
        rank = sc.next();
        System.out.println("Write your city:");
        String city = sc.nextLine();
        city = sc.nextLine();
        String accname;
        while (true) {
            System.out.println("Enter your accaunt name:");
            accname = sc.nextLine();
            if (instructorController.checkForAccountInstructor(accname) == null) {
                break;
            } else {
                System.out.println("We hava such a User!");
                continue;
            }
        }
        System.out.println("Enter your password for your account:");

        while (true){
            System.out.println("Password must to contain at least \n1 uppercase letter, \n1 lowercase letter, \n1 digit, \n1 special symbol(@,$).");
            password=sc.nextLine();
            if(validator.checkPassword(password)==true){
                break;
            }else{
                continue;
            }
        }

        boolean result=instructorController.signInAsInstructor(name,surename,age,rank,city,accname,password);
        if (result==true){
            System.out.println("You've been successfully registered!");
        }else{
            System.out.println("Sorry something gone wrong!");
        }
    }

    public void logInInstructorMenu (){
        System.out.println("========================");
        int option;
        String accname=null;
        boolean checkpassword;
        String password;
        checkpassword=false;
        String realPassword=null;

        System.out.println("Enter your account name:");

        accname=sc.next();
        while (realPassword==null){



            realPassword=instructorController.logInAsInstructor(accname);


            if (realPassword!=null){
                break;
            }else {
                System.out.println("Wrong account name, Enter again:");
                accname=sc.next();
                continue;
            }
        }


        System.out.println("Enter password:");
        password=sc.next();



        while(checkpassword==false){

            checkpassword =validator.checkPasswordLogIn(password,realPassword);


            if (checkpassword==true){
                break;
            }else{
                System.out.println("Wrong password! ENTER AGAIN!");
                password=sc.next();
            }

        }
        System.out.println("You entered!");
        int i;
        while (true){
            System.out.println("========================");
            System.out.println("Enter option:");
            System.out.println("1)Get all students\n2)Search student by name\n3)Get student by id\n4)Register student\n5)Remove student by id\n6)Put a mark");
            i=sc.nextInt();
            String response=null;
            if (i==0){
            break;
            }
            else if(i==1){
            getAllStudents();
            }else if (i==2){
            getStudentByName();
            }else if(i==3){
            getStudentById();
            }else if(i==4){
            addStudent();
            }else if(i==5){
            removeStudentById();
            }else if(i==6) {
            putMark();
            }else{
                System.out.println("We do not have such an option!");
            }



        }
    }
    public  void  getAllStudents(){
        String result=instructorController.getAllStudents();
        System.out.println(result);
    }
    public void getStudentByName(){
        System.out.println("Enter student's name:");
        String name=sc.next();
        String result=instructorController.searchStudentByName(name);
        System.out.println(result);
    }
    public void getStudentById(){
        System.out.println("Enter student's id:");
        int id=sc.nextInt();
        String result=instructorController.getStudentById(id);
        System.out.println(result);
    }
    public void removeStudentById(){
        System.out.println("Enter student's id:");
        int id=sc.nextInt();
        String result=instructorController.removeStudentById(id);
        System.out.println(result);
    }
    public void addStudent(){
        boolean checkpassword = false;
        String password = "000";
        System.out.println("Write student's name:");
        String name = sc.next();
        System.out.println("Write student's surname:");
        String surename = sc.next();
        System.out.println("Write student's adress:");
        String adress = sc.nextLine();
        adress = sc.nextLine();
        System.out.println("Enter student's City:");
        String city = sc.nextLine();
        System.out.println("Write student's distinct:");
        String distinct = sc.nextLine();
        String accname;
        while (true) {
            System.out.println("Enter student's accaunt name:");
            accname = sc.next();
            if (studentController.checkForAccountStudent(accname) == null) {
                break;
            } else {
                System.out.println("We hava such a User!");
                continue;
            }
        }
        System.out.println("Enter student's password for student's account:");

        while (true){
            System.out.println("Password must to contain at least \n1 uppercase letter, \n1 lowercase letter, \n1 digit, \n1 special symbol(@,$).");
            password=sc.nextLine();
            if(validator.checkPassword(password)==true){
                break;
            }else{
                continue;
            }
        }
        String result=studentController.signInStudent(name,surename,adress,city,distinct,accname,password);

        System.out.println(result);
    }

    public void putMark(){
        System.out.println("Enter student's id:");
        int id =sc.nextInt();
        System.out.println("Enter student's course:");
        String course=sc.next();
        System.out.println("Enter grade:");
        int grade=sc.nextInt();
        System.out.println("Enter lesson's number:");
        int lessonnumber=sc.nextInt();
        String result=gradeController.putMarks(id,course,grade,lessonnumber);
        System.out.println(result);
    }



}
