package com.cpg.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cpg.dao.EmployeeDaoImpl;
import com.cpg.dao.IEmployeeDao;
import com.cpg.exception.EmptyEmployeeObjectException;
import com.cpg.model.Employee;

class EmployeeServiceImplTest {

	private static IEmployeeDao empDao;
	private static Employee emp;
	
	@BeforeEach
	void setUp() throws Exception {
		IEmployeeDao empDao=new EmployeeDaoImpl();
		Employee emp=new Employee();
	}

	@AfterEach
	void tearDown() throws Exception {
		empDao=null;
		emp=null;
	}

	@Test
	void testSelectInsurance() throws EmptyEmployeeObjectException {
		emp.setId(1);
		emp.setName("Avi");
		emp.setSalary(500);
		empDao.addEmployee(emp);
		String designation=emp.getDesignation();
		assertNotNull(designation);
		fail("Not yet implemented");
	}

	@Test
	void testGiveDesignation() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmployee() {
		fail("Not yet implemented");
	}

}
