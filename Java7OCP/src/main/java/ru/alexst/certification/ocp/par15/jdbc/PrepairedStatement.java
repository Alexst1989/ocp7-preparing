package ru.alexst.certification.ocp.par15.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrepairedStatement {

    private static final Logger LOGGER = LogManager.getLogger(PrepairedStatement.class);

    private static final String PREPAIRED_STRING = "SELECT * FROM books WHERE full_name like ?";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connString = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "WEBSERVICE";
        String pass = "WEBSERVICE";
        try (Connection conn = DriverManager.getConnection(connString, user, pass)) {
            PreparedStatement stmt = conn.prepareStatement(PREPAIRED_STRING);
            stmt.setString(1, "%Pol%");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                LOGGER.info(String.format("%s %s %s", resultSet.getString("ID"), resultSet.getString("SHORT_NAME"), resultSet.getString("FULL_NAME")));
            }
        } catch (SQLException e) {
            LOGGER.info("SQL Exception", e);
        }
    }

}
