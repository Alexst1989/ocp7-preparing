package ru.alexst.certification.ocp.par15.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JdbcTransactions {

    private static final Logger LOGGER = LogManager.getLogger(JdbcTransactions.class);

    private static final String PREPAIRED_STRING = "UPDATE BOOKS SET SHORT_NAME = ? WHERE ID < 6 AND ID > 3";
    
    /*
     Note that both commit() and rollback() are transaction methods, and if
either of these methods is invoked when a Connection is not in a transaction (for
example, when a Connection is in auto-commit mode), these methods will throw
a SQLException.
     
     
     One final point on the setAutoCommit() method. If auto-commit is
turned back on during a transaction, i.e., setAutoCommit(true), any current transaction
is committed and auto-commit mode is then turned back on. Turning auto-commit on
and off is not something likely to happen a lot in actual code, but it is something that the
exam developers thought you ought to know in the context of transactions with JDBC.

■ When you set Savepoint A and then later set Savepoint B, if you roll back to
Savepoint A, you automatically release and invalidate Savepoint B.
■ Support for Savepoints is not required, but you can check to see if your
JDBC driver and database support Savepoints using the DatabaseMetaData
.supportsSavePoints() method, which will return true if Savepoints are
supported.
■ Because a Savepoint is an actual point-in-time state of a transaction context,
the number of Savepoints supported by your JDBC driver and database may
be limited. For example, the Java DB database does support Savepoints, but
only one per transaction.

     */

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connString = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "WEBSERVICE";
        String pass = "WEBSERVICE";
        try (Connection conn = DriverManager.getConnection(connString, user, pass)) {
            conn.setAutoCommit(false); //Open a transaxtion
            PreparedStatement stmt = conn.prepareStatement(PREPAIRED_STRING);
            stmt.setString(1, "OPA");
            ResultSet resultSet = stmt.executeQuery();
            conn.commit(); //Close Transaction throws SQLException
            
            conn.setAutoCommit(false); //Open new
            stmt.setString(1, "OPA3");
            stmt.executeQuery();
            conn.rollback(); // rollback
            
            DatabaseMetaData dbmd = conn.getMetaData();
            LOGGER.info(String.format("Database meta. getDatabaseProductName = %s", dbmd.getDatabaseProductName()));
            LOGGER.info(String.format("Database meta. getDatabaseProductVersion = %s", dbmd.getDatabaseProductVersion()));
            LOGGER.info(String.format("Database meta. getDefaultTransactionIsolation = %s", dbmd.getDefaultTransactionIsolation()));
            LOGGER.info(String.format("Database meta. getDriverName = %s", dbmd.getDriverName()));
            LOGGER.info(String.format("Database meta. getDriverVersion = %s", dbmd.getDriverVersion()));
            LOGGER.info("Procedures:");
            printResultSet(dbmd.getProcedures(null, "WEBSERVICE", "%BOOK"));

            
            //conn.setAutoCommit(true); //
            /*while (resultSet.next()) {
                LOGGER.info(String.format("%s %s %s", resultSet.getString("ID"), resultSet.getString("SHORT_NAME"), resultSet.getString("FULL_NAME")));
            }*/
        } catch (SQLException e) {
            LOGGER.info("SQL Exception", e);
        }
    }
    
    public static void printResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            LOGGER.info(String.format("Procedure name = %s", rs.getString("PROCEDURE_NAME")));
        }
    }
   

}
