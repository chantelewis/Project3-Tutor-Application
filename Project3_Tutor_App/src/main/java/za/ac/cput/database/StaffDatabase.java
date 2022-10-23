package za.ac.cput.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class StaffDatabase {

    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "Giant123";

    public static void main(String[] args) throws SQLException {

        // Creating the database
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE DATABASE projectApp";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");

        } catch (SQLException e) {
            System.out.println("Database already created.");;
        }

        try {
            // Adding tables to the database (staff table)
            //Registering the Driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://localhost/projectApp";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", PASS);
            Statement stmt = con.createStatement();
            System.out.println("Connection established......");

            //Query to create a table
            String sqlCreateStaff = "CREATE TABLE if not exists Staff ("
                    + "StaffID VARCHAR(13) NOT NULL,"
                    + "Name VARCHAR(16) NOT NULL,"
                    + "Surname VARCHAR(255) NOT NULL,"
                    + "Gender VARCHAR(32) NOT NULL,"
                    + "Email VARCHAR(45) NOT NULL,"
                    + "Address VARCHAR(45) NOT NULL,"
                    + "Course VARCHAR(45) NOT NULL,"
                    + "Password VARCHAR(45) NOT NULL,"
                    + "PRIMARY KEY (StaffID))";

            String updateTable = "INSERT INTO Staff (StaffID, Name, Surname, Gender, Email, Address, Course, Password) VALUES" +
                    "('0192038948993','Natasha', 'James', 'Female', 'natasha@james.co.za', '22 lions head road', 'ADT', 'MYDOG!s2cute'),"+
                    "('2637719021233','Larry', 'Wise', 'Male', 'larry@wise.co.za', '1 table mountain road', 'ITS', '@Ilovel0v3'),"+
                    "('7890111178990','Bloomy', 'Xolo', 'Female', 'bloomy@xolo.ac.za', '22 lions head road', 'ADT', 'lotto!isaddictiv3');";


            stmt.execute(sqlCreateStaff);
            stmt.executeUpdate(updateTable);

            System.out.println("Table Created......");
        }catch(SQLException e) {
            System.out.println(e);
        }






    }
}