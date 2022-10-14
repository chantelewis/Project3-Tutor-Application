package za.ac.cput.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) throws SQLException {

        // Creating the database
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE DATABASE tutorApp";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");

            // Adding tables to the database (resource table)
            //Registering the Driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://localhost/tutorApp";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
            System.out.println("Connection established......");

            //Query to create a table
            String sqlCreateResource = "CREATE TABLE resources ("
                    + "Item_Name varchar(255) NOT NULL,"
                    + "Description varchar(1000) NOT NULL DEFAULT 'Description about the item.',"
                    + "Owner_Contact varchar(255) NOT NULL,"
                    + "Availability varchar(5) NOT NULL,"
                    + "ImageID varchar(255) NOT NULL,"
                    + "PRIMARY KEY (Item_Name))";

            String updateTable = "INSERT INTO resources (Item_Name, Description, Owner_Contact, Availability, ImageID) VALUES" +
                    "('Test Driven Development: By Example', 'This book follows two TDD projects from start to finish, illustrating techniques programmers can use to easily and dramatically increase the quality of their work. The examples are followed by references to the featured TDD patterns and refactorings. With its emphasis on agile methods and fast development strategies, Test-Driven Development is sure to inspire readers to embrace these under-utilized but powerful techniques', '38215@mycput.ac.za', 'true', 'IMG_TDD.png')," +
                    "('Software Engineering 10th Edition', 'Software Engineering introduces readers to the overwhelmingly important subject of software programming and development. In the past few years, computer systems have come to dominate not just our technological growth, but the foundations of our world’s major industries. This text seeks to lay out the fundamental concepts of this huge and continually growing subject area in a clear and comprehensive manner.', '382123@mycput.ac.za', 'true', 'IMG_SOFTENG.png')," +
                    "('Design Patterns: Elements of Reusable Object-Oriented Software', 'The book is divided into two parts, with the first two chapters exploring the capabilities and pitfalls of object-oriented programming, and the remaining chapters describing 23 classic software design patterns. The book includes examples in C++ and Smalltalk.', '281980@mycput.ac.za', 'false', 'IMG_DESPATS.png');";

            stmt.execute(sqlCreateResource);
            stmt.executeUpdate(updateTable);

            System.out.println("Table Created......");

        } catch (SQLException e) {
            System.out.println("Database already created.");;
        }




    }

}
