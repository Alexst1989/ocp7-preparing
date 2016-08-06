package ru.alexst.certification.ocp.par7.assertionsexceptions;

import java.io.IOException;
import java.sql.SQLException;

/*
Remember, multi-catch is only for exceptions in different inheritance hierarchies

CANT assign multi-catch block variable ! Compilation error

 */

public class NewInExceptions {

    public static void doSomething(boolean b) throws IOException, SQLException {
        System.out.println("doSomething");
        if (b) {
            throw new IOException("IOExeption");
        } else {
            throw new SQLException("SQLException");
        }
    }

    public static void couldThrowAnException() throws IOException, SQLException {
    }

    public void rethrow() throws SQLException, IOException {
        try {
            couldThrowAnException();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            throw e;
        }
    }

    // Compiler knows that throw e will actually throws SQLException or IOException, not any Exception
    public static void rethrow2() throws SQLException, IOException {
        try {
            couldThrowAnException();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    // But when you assign some exception to "e" the will no longer compiles
    public void rethrow3() throws SQLException, IOException {
        try {
            couldThrowAnException();
        } catch (Exception e) {
            e = new IOException();
            // If you assign a value to the catch parameter, the code no
            // longer compiles:
            // throw e;
        }
    }

    public static void main(String args[]) {

        try {
            // doSomething(true);
            rethrow2();
            // catch(IOException e1 | SQLException e2) // WONT COMPILE !!!!!
            // catch(IOException e | SQLException e) // WONT COMPILE !!!!!
            // catch(FileNotFoundException | IOException e) // WONT COMPILE !!!!! FileNotFoundException already caught
            // by IOException
        } catch (IOException | SQLException e) {
            System.out.println("Exception = " + e);
        }

        try {
            doSomething(true);
            // access the database and write to a file
            // } catch (Exception e) { //WONT COMPILE !!!!! broader exceptions must be at the end

        } catch (SQLException | IOException e) {
            // e = new IOException(); //WONT COMPILE !!!!! CANT assign multi-catch block variable
        } catch (Exception e) {
            e = new RuntimeException(); // however, this is legal
        }

    }

}
