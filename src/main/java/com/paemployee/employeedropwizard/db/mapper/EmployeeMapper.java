package com.paemployee.employeedropwizard.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.paemployee.employeedropwizard.core.Employee;

public class EmployeeMapper implements ResultSetMapper<Employee> {
	@Override
	public Employee map(int index, ResultSet resultset, StatementContext statementContext) throws SQLException
	{
		return new Employee(resultset.getInt("ID"), resultset.getString("NAME"), resultset.getInt("SALARY"));	
	}

}
