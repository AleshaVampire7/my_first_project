package Controllers;

import Entities.Grade;
import Entities.Student;
import Repository.GradeRepository;
import Repository.GradeRepositoryUpdated;

import java.util.ArrayList;
import java.util.List;
//Here this controller controls flow of the data between app and repository
public class GradeController {
    GradeRepository gradeRepository;
    GradeRepositoryUpdated gradeRepositoryUpdated;
    public GradeController(GradeRepository gradeRepository,GradeRepositoryUpdated gradeRepositoryUpdated) {
        this.gradeRepository=gradeRepositoryUpdated;
        this.gradeRepositoryUpdated=gradeRepositoryUpdated;
    }
    public String getAllGrades(){
        List<Grade> response=gradeRepositoryUpdated.getAllGrades();
       if(response==null){
           return "You do not have grades!";
       }else{
           return response.toString();
       }

    }
    public String putMarks(int id,String course,int grade,int lessonnumber){
        boolean response=gradeRepository.putMarks(new Grade(id,course,grade,lessonnumber));
        if (response){
            return "Grade was successfully added!";
        }else{
            return "Something went wrong!";
        }
    }
    public String seeGradeByCourse(String course){
        List<Grade> response=gradeRepositoryUpdated.seeGradeByCourse(course);
        if (response==null){
            return "We do not have such grades!";
        }else{
            return response.toString();
        }
    }
}
