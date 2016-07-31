package ru.alexst.certification.ocp.par15.jdbc;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JdbcBasic {
    
    static {
        URL url = Thread.currentThread().getContextClassLoader().getResource("log4j.properties");
        System.out.println(url);
    }
    
    private static final Logger LOGGER = LogManager.getLogger(JdbcBasic.class);
    
    private static final String TEST_QUERY = "SELECT * FROM books";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connString = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "WEBSERVICE";
        String pass = "WEBSERVICE";
        try (Connection conn = DriverManager.getConnection(connString, user, pass)) {   
            PreparedStatement stmt = conn.prepareStatement(TEST_QUERY);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                LOGGER.info(String.format("%s %s %s", 
                        resultSet.getString("ID"), 
                        resultSet.getString("SHORT_NAME"), 
                        resultSet.getString("FULL_NAME")));
                System.out.print(resultSet.getString("ID") + "\t");
                System.out.print(resultSet.getString("SHORT_NAME") + "\t\t");
                System.out.println(resultSet.getString("FULL_NAME"));
            }
        } catch (SQLException e) {
            LOGGER.info("SQL Exception", e);
        }
    }

}
