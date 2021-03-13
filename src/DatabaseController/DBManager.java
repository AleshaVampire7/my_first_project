package DatabaseController;

import DatabaseController.Interface.IDBManager;

import java.sql.Connection;
import java.sql.DriverManager;
//Here we have method that establishes connection with DB
public class DBManager implements IDBManager {
    @Override
    public Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","KAD2020a");
            return  connection;
        }catch (Exception e){
            System.out.println("You have got an error with the connection!");
            System.out.println(e.getStackTrace());
        }
        return  null;
    }
}
