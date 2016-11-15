package ru.alexst.certification.ocp.par15.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
JdbcRowSet extends RowSet, Joinable - connected row set
    
    CachedRowSet extends RowSet, Joinable - disconnected row set
        - WebRowSet extends CachedRowSet - disconnected row set
            - JoinRowSet extends WebRowSet - disconnected row set
            - FilteredRowSet extends WebRowSet - disconnected row set
    

RowSet is a ResultSet

JbdcRowSet A connected RowSet; acts as JavaBeans component by providing a thin wrapper around
            a ResultSet; useful for applications that benefit from the event model supported by
            JdbcRowSet.
            
CachedRowSet A disconnected RowSet; provides an offline representation of a RowSet; useful for
            applications where the data needs to be available when the database is not (for example,
            in a portable device).
            
WebRowSet A CachedRowSet that can write itself as an XML file and read an XML file to re-create a
            WebRowSet. Useful in applications where XML data is a requirement.
            
FilteredRowSet A WebRowSet that provides the additional capability of filtering its contents.
            FilteredRowSets can use a Predicate object to control what data is returned.
            
            
JoinRowSet A WebRowSet that can combine related data from multiple RowSets into a single
            JoinRowSet. A useful alternative to the use of a SQL JOIN statement. 
 */

public class JdbcRowSetBasic {
    
    private static final Logger LOGGER = LogManager.getLogger(JdbcRowSetBasic.class);

    //private static final String TEST_QUERY = "SELECT ID, SHORT_NAME, FULL_NAME FROM books";
    
    private static final String TEST_QUERY = "SELECT books.* FROM books";
    private static final String COL_ID = "ID";
    private static final String COL1 = "SHORT_NAME";
    private static final String COL2 = "FULL_NAME";
    

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connString = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "WEBSERVICE";
        String pass = "WEBSERVICE";
        
        try (//Connection conn = DriverManager.getConnection(connString, user, pass);
                //PreparedStatement stmt = conn.prepareStatement(arg0, arg1, arg2, arg3)
                JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet()) {
            rowSet.addRowSetListener(new MyRowSetListener());
            rowSet.setCommand(TEST_QUERY);
            rowSet.setUrl(connString);
            rowSet.setUsername(user);
            rowSet.setPassword(pass);
            rowSet.execute();
            printResult(rowSet);
            
            //UpdateRow
            rowSet.absolute(1);
            rowSet.updateString(COL_ID, "13");
            rowSet.updateRow();
            printResult(rowSet);
            
            //InsertRow
            rowSet.moveToInsertRow();
            rowSet.updateInt(COL_ID, 46);
            rowSet.updateString(COL1, "OOP2");
            rowSet.updateString(COL2, "Patterns2");
            rowSet.insertRow();
            printResult(rowSet);
            
            
        } catch (SQLException e) {
            LOGGER.info("SQL Exception", e);
        }
    }
    
    public static void printResult(ResultSet resultSet) throws SQLException {
        resultSet.absolute(0);
        StringBuilder sb = new StringBuilder("");
        while (resultSet.next()) {
            sb.append(String.format("%s   %s    %s \r\n", 
                    resultSet.getInt("ID"),
                    resultSet.getString("SHORT_NAME"),
                    resultSet.getString("FULL_NAME")));
            
        } 
        LOGGER.info(sb.toString());
    }
    
}

/*
■ public void cursorMoved(RowSetEvent event) Receives an event for
every movement of the cursor. This method is called a lot, for example, once
for every invocation of next(), so be judicious of its use.
■ public void rowChanged(RowSetEvent event) Receives an event
when a row is updated, inserted, or deleted. This is a good method to use to
refresh the RowSet.
■ public void rowSetChanged(RowSetEvent event) Receives an event
when the entire RowSet is changed, so for every invocation of execute().
 */
class MyRowSetListener implements RowSetListener {
    
    private static final Logger LOGGER = LogManager.getLogger(MyRowSetListener.class);

    @Override
    public void cursorMoved(RowSetEvent arg0) {
        LOGGER.info("Cursor moved" + arg0.getSource());
    }

    @Override
    public void rowChanged(RowSetEvent arg0) {
        LOGGER.info("Row Is Changed. Refreshing the row set");
        try {
            ((RowSet)(arg0.getSource())).execute();
        } catch (SQLException e) {
            LOGGER.error("RowChanged refresh error", e);
        }
    }

    @Override
    public void rowSetChanged(RowSetEvent arg0) {
        LOGGER.info("Row Set Chaned");
    }
    
}
