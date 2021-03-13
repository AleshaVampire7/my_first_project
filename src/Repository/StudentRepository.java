package Repository;

import DatabaseController.DBManager;
import Entities.Student;
import Repository.Interfaces.IStudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//Executable statemnets are stored here also methods that are used in our app.
public class StudentRepository implements IStudentRepository {
    DBManager dbManager;
    public StudentRepository(DBManager dbManager) {this.dbManager=dbManager; }
    public  boolean signAsStudent(Student student) {

        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (name,surename,adress,city,distinct1,accname,password) VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurename());
            preparedStatement.setString(3, student.getAdress());
            preparedStatement.setString(4,student.getCity());
            preparedStatement.setString(5,student.getDistinct());
            preparedStatement.setString(6,student.getAccname());
            preparedStatement.setString(7,student.getPassword());
            preparedStatement.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }



    public  String logInStudent(String accname) {

        Connection connection = null;
        try {
            String password;
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM student  where accname=?");
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


    public String searchingForAccnameStudent(String accname) {
        Connection connection = null;
        String name;

        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM student  where accname=?");
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
}
