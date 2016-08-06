package ru.alexst.certification.ocp.par15.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CachedRowSetBasic {

    private static final Logger LOGGER = LogManager.getLogger(JdbcRowSetBasic.class);

    // private static final String TEST_QUERY = "SELECT ID, SHORT_NAME, FULL_NAME FROM books";

    private static final String TEST_QUERY = "SELECT books.* FROM books";
    private static final String COL_ID = "ID";
    private static final String COL1 = "SHORT_NAME";
    private static final String COL2 = "FULL_NAME";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connString = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "WEBSERVICE";
        String pass = "WEBSERVICE";

        try (// Connection conn = DriverManager.getConnection(connString, user, pass);
             // PreparedStatement stmt = conn.prepareStatement(arg0, arg1, arg2, arg3)
                CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet()) {
            crs.addRowSetListener(new MyRowSetListener());
            crs.setCommand(TEST_QUERY);
            crs.setUrl(connString);
            crs.setUsername(user);
            crs.setPassword(pass);
            crs.execute();
            printResult(crs);
            
            crs.moveToCurrentRow();
            crs.updateString(1, "OOOGH");
            crs.moveToInsertRow();
            // REMEMBER. Push to DB. Does not work
            crs.acceptChanges();
        } catch (SQLException e) {
            LOGGER.info("SQL Exception", e);
        }
    }

    public static void printResult(ResultSet resultSet) throws SQLException {
        resultSet.beforeFirst();
        StringBuilder sb = new StringBuilder("");
        LOGGER.info("Current position" + resultSet.getRow());
        while (resultSet.next()) {
            sb.append(String.format("%s   %s    %s \r\n", resultSet.getInt("ID"), resultSet.getString("SHORT_NAME"), resultSet.getString("FULL_NAME")));

        }
        LOGGER.info(sb.toString());
    }
}
