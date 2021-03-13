package Repository.Interfaces;

import Entities.Grade;
import Entities.Student;
//Here we stored methods that have to be in implementing class.
import java.util.List;

public interface IGradeRepository {
    public List<Grade> getAllGrades();
    public boolean putMarks(Grade grade);
}
