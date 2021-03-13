package Repository;

import DatabaseController.DBManager;
import Entities.Grade;
import Entities.Student;
import Repository.Interfaces.IGradeRepositoryUpdated;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//Executable statemnets are stored here also methods that are used in our app.
public class GradeRepositoryUpdated extends GradeRepository implements IGradeRepositoryUpdated {
    public GradeRepositoryUpdated(DBManager dbManager) {
        super(dbManager);
    }

    @Override
    public List<Grade> seeGradeByCourse(String course) {

            Connection connection = null;

            try {
                connection = dbManager.getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM grade WHERE course LIKE '%" + course + "%'");


                ResultSet resultSet = preparedStatement.executeQuery();

                List<Grade> grades = new LinkedList<>();

                while (resultSet.next()) {
                    Grade grade = new Grade(resultSet.getInt("studentid"),
                            resultSet.getString("course"),
                            resultSet.getInt("grade"),
                            resultSet.getInt("lessonnumber"));

                    grades.add(grade);
                }
                return grades;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;

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
                Grade grade = new Grade(resultSet.getInt("studentid"),
                        resultSet.getString("course"),
                        resultSet.getInt("grade"),
                        resultSet.getInt("lessonnumber"));

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
