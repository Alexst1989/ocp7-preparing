package ru.alexst.certification.ocp.par7.assertionsexceptions;

import java.io.IOException;
import java.sql.SQLException;

public class TryResourceSteps {

    public static void main(String[] args) {
        System.out.println("1");
        try (AutoC auto = new AutoC()) {
            System.out.println("2");
            throw new IOException();
        } catch (SQLException e) {
            System.out.println("unreachable");
        } catch (IOException e) {
            System.out.println("4");
            System.out.println(e.getSuppressed()[0]);
        } finally {
            System.out.println("5");
        }

        System.out.println("1");
        try (AutoC2 auto = new AutoC2();) {
            System.out.println("2");
            throw new IOException();
        } catch (IOException e) {
            System.out.println("4");
            System.out.println(e.getSuppressed().length);
        } finally {
            System.out.println("5");
        }

    }

}

class AutoC implements AutoCloseable {

    @Override
    public void close() throws SQLException {
        System.out.println("3");
        throw new SQLException("hello exception");
    }

}

class AutoC2 implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("3");
    }

}