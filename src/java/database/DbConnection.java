
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

    static Connection con = null;
    static Statement st = null;

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/donors", "root", "root");
            System.out.println("connected");

            st = con.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);

        }

    }

    public static Statement getStatement() {
        return st;
    }

    public static Connection getConnection() {
        return con;
    }
}
