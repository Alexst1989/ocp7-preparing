package ru.alexst.certification.ocp.par7.assertionsexceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

/*
    SCOPE IN TRY WITH RESOURCE!!!!!!!!!!!
    Here, the reader is scoped to just the try block.
    Not the catch block; just the try block
    
    catch block optional as before
    
    Try-with-resource can be without catch block, because compiler logically calls finally block, 
    but you don't see it
    
    You can add more then one resource in try-with-resource
    
    You can add your own finally block in try-with-resource. Both will be called, logical and yours
    
    Compiler error occurs when you place class in try-with-resource which doesn't implement AutoCloseable interface
    
*/
public class TryWithResource {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\�������\\Java ����������\\file.txt");
        try (Reader reader = new BufferedReader(new FileReader(file))) { 
            // note the new syntax
            // read from file
        } catch (IOException e) {
            System.out.println(e);
            // throw e;
        }

        try (Reader reader = new BufferedReader(new FileReader(file))) { 
            // Without catch or finally block
            //
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try (Reader reader = new BufferedReader(new FileReader(file)); AutoCloseableClass myResource = new AutoCloseableClass()) { 
            // More than one resource
            //
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } finally {
            System.out.println("SECONDLY Finally catch block of try-with-resource");
        }
    }

}
