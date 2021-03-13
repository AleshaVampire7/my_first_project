package Repository;

import DatabaseController.DBManager;
import Entities.Grade;
import Entities.Student;
import Repository.Interfaces.IGradeRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
//Executable statemnets are stored here also methods that are used in our app.
public class GradeRepository implements IGradeRepository {

    DBManager dbManager;
    public GradeRepository(DBManager dbManager) {
        this.dbManager=dbManager;
    }

    public boolean putMarks(Grade grade) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO grade  VALUES(?,?,?,?)");

            preparedStatement.setInt(1,grade.getId());
            preparedStatement.setString(2, grade.getCourse());
            preparedStatement.setInt(3, grade.getGrade());
            preparedStatement.setInt(4,grade.getLessonnumber());
            preparedStatement.execute();


            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

       return false;
    }
    public List<Grade> getAllGrades() {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            String sql = "SELECT * FROM grade";
            Statement st = con.createStatement();


            ResultSet resultSet = st.executeQuery(sql);
            List<Grade> grades = new LinkedList<>();
            while (resultSet.next()) {
                Grade grade = new Grade(resultSet.getInt("id"),
                        resultSet.getString("course"),
                        resultSet.getInt("grade"));
                grades.add(grade);
            }
            return grades;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}
