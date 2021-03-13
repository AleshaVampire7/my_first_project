package Repository.Interfaces;

import Entities.Grade;

import java.util.ArrayList;
import java.util.List;
//Here we stored methods that have to be in implementing class.
public interface IGradeRepositoryUpdated {
    public List<Grade> seeGradeByCourse(String course);
    public List<Grade> getAllGrades();
}
