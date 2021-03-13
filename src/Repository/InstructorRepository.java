package Repository;

import DatabaseController.DBManager;
import Entities.Instructor;
import Entities.Student;
import Repository.Interfaces.IInstructorRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//Executable statemnets are stored here also methods that are used in our app.
public class InstructorRepository implements IInstructorRepository {
    DBManager dbManager=new DBManager();
    public InstructorRepository(DBManager dbManager) { this.dbManager=dbManager;}


    public  boolean signInInstructor(Instructor instructor) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO instructor (name,surename,age,rank,city,accname,password) VALUES(?,?,?,?,?,?,?)");

            preparedStatement.setString(1, instructor.getName());
            preparedStatement.setString(2, instructor.getSurename());
            preparedStatement.setInt(3, instructor.getAge());
            preparedStatement.setString(4,instructor.getRank());
            preparedStatement.setString(5,instructor.getCity());
            preparedStatement.setString(6,instructor.getAccname());
            preparedStatement.setString(7,instructor.getPassword());

            preparedStatement.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }



    public  String logInInstructor(String accname) {
        Connection connection = null;
        String password;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM instructor  where accname=?");

            preparedStatement.setString(1, accname);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                password = resultSet.getString("password");
                return password;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }




    public String searchingForAccnameInstructor(String accname) {
        Connection connection = null;
        String name;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM instructor  where accname=?");

            preparedStatement.setString(1, accname);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                name = resultSet.getString("name");
                return name;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Student> getAllStudents() {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            String sql = "SELECT * FROM student";
            Statement st = con.createStatement();


            ResultSet resultSet = st.executeQuery(sql);
            List<Student> students = new LinkedList<>();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surename"),
                        resultSet.getString("adress"),
                        resultSet.getString("city"),
                        resultSet.getString("distinct1"));

                students.add(student);
            }
            return students;
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


    public List<Student> searchStudentByName(String name) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE name LIKE '%" + name + "%'");

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> students = new LinkedList<>();

            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surename"),
                        resultSet.getString("adress"),
                        resultSet.getString("city"),
                        resultSet.getString("distinct1"));
                students.add(student);
            }

            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Student getStudentById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Student student = new Student();

            if (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurename(resultSet.getString("surename"));
                student.setAdress(resultSet.getString("adress"));
                student.setCity(resultSet.getString("city"));
                student.setDistinct(resultSet.getString("distinct1"));

            }

            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public boolean addStudent(Student student) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (name, surename, adress, city, distinct1,accname,password) VALUES(?,?,?,?,?,?,?)");

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurename());
            preparedStatement.setString(3, student.getAdress());
            preparedStatement.setString(4, student.getCity());
            preparedStatement.setString(5, student.getDistinct());
            preparedStatement.setString(6,student.getAccname());
            preparedStatement.setString(7,student.getPassword());
            preparedStatement.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean removeStudentById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
