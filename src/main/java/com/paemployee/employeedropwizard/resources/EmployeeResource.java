package com.paemployee.employeedropwizard.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paemployee.employeedropwizard.core.Employee;
import com.paemployee.employeedropwizard.db.dao.EmployeeDAO;

@Path("/employee")
public class EmployeeResource {

	EmployeeDAO employeedao;

	public EmployeeResource(EmployeeDAO employeedao) {
		this.employeedao = employeedao;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Employee> getAllEmp() {
		return employeedao.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee getEmpById(@PathParam("id") int id) {
		return employeedao.findById(id);

	}

	@DELETE
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public int delete(@PathParam("id") Integer id) {

		if (id == employeedao.isEmployeeExist(id)) {
			return employeedao.deleteById(id);
		} else
			return 0;

	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee update(Employee employee) {

		if (employee.getId() == employeedao.isEmployeeExist(employee.getId())) {
			employeedao.update(employee);
			return employeedao.findById(employee.getId());
		} else
			return employee;

	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public int add(@Valid Employee employee) {
		return employeedao.insert(employee);
	}

}
