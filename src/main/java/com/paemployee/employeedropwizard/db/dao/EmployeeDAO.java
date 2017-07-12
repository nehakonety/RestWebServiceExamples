package com.paemployee.employeedropwizard.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.paemployee.employeedropwizard.core.Employee;
import com.paemployee.employeedropwizard.db.mapper.EmployeeMapper;

@RegisterMapper(EmployeeMapper.class)
public interface EmployeeDAO {
	
	@SqlQuery("select * from EMPLOYEE")
	List<Employee> getAll();
	
	@SqlQuery("select * from EMPLOYEE where ID = :id")
	Employee findById(@Bind("id") int id);
	
	@SqlQuery("select ID from EMPLOYEE where ID = :id")
	int isEmployeeExist(@Bind("id") int id);	
	
	@SqlUpdate("delete from EMPLOYEE WHERE ID = :id")
	int deleteById(@Bind("id") int id);
	
	@SqlUpdate("update EMPLOYEE set NAME = :name, SALARY = :salary WHERE ID = :id")
	int update(@BindBean Employee emp);
	
	@SqlUpdate("insert into EMPLOYEE (ID, NAME, SALARY) values (:id, :name, :salary)")
	int insert(@BindBean Employee emp);
}
