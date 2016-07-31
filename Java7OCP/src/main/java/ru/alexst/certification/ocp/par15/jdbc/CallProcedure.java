package ru.alexst.certification.ocp.par15.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CallProcedure {
    
    private static final Logger LOGGER = LogManager.getLogger(CallProcedure.class);

    private static final String PREPAIRED_STRING = "{call INSERTBOOK(?, ?, ?)}";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connString = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "WEBSERVICE";
        String pass = "WEBSERVICE";
        try (Connection conn = DriverManager.getConnection(connString, user, pass)) {
            CallableStatement cstmt = conn.prepareCall(PREPAIRED_STRING);
            cstmt.setInt(1, 6);
            cstmt.setString(2, "Java 2");
            cstmt.setString(3, "Java Language specification part 2");
            LOGGER.info(cstmt.execute());
        } catch (SQLException e) {
            LOGGER.error("SQL Exception", e);
        }
    }

}
