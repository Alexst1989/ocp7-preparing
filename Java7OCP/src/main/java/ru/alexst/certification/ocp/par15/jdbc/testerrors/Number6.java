package ru.alexst.certification.ocp.par15.jdbc.testerrors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Recall that the try-with-resources statement on line X will automatically
close the resource specified at the close of the try block (when the closing curly brace is
reached), and closing the Statement object automatically closes any open ResultSets
associated with the Statement. The SQLException thrown is that the ResultSet is not open.
To fix this code, move the while statement into the try-with-resources block.
*/

public class Number6 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connString = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "WEBSERVICE";
        String pass = "WEBSERVICE";
        try (Connection conn = DriverManager.getConnection(connString, user, pass)) {
            try {
                ResultSet rs = null;
                try (Statement stmt = conn.createStatement()) { // line X
                    String query = "SELECT * from Books";
                    rs = stmt.executeQuery(query); // line Y
                } catch (SQLException ex) {
                    System.out.println("Illegal query");
                }
                while (rs.next()) {
                    // print customer names
                }
            } catch (SQLException ex) {
                System.out.println("SQLException");
            }
        }
    }

}
