package ru.alexst.certification.ocp.par7.assertionsexceptions;

import java.sql.SQLException;

public class AutoCloseableClass implements AutoCloseable {

	@Override
	public void close() throws SQLException {
		System.out.println("FIRSTLY close method in AutoCloseableClass");
	}

}
