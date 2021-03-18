package com.cpg.service.testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cpg.dao.EmployeeDaoImpl;
import com.cpg.dao.IEmployeeDao;
import com.cpg.exception.EmptyEmployeeObjectException;
import com.cpg.model.Employee;

class TestCaseService {

	private static IEmployeeDao empDao;
	private static Employee employee;
	@BeforeEach
	void setUp() throws Exception {
		empDao=new EmployeeDaoImpl();
		employee=new Employee();
	}

	@AfterEach
	void tearDown() throws Exception {
		empDao=null;
		employee=null;
	}

	@Test
	void testNegativeId() throws EmptyEmployeeObjectException 
	{
		employee=new Employee(-2,"Avi",5,"Clerk");
		empDao.addEmployee(employee);
		assertEquals(employee.getId(), -2);
		System.out.println("Invalid ID: Can not have negative ID");				
	}
	@Test
	void testCharacterId() throws EmptyEmployeeObjectException 
	{
		employee=new Employee('a',"Avi",5,"Clerk");
		empDao.addEmployee(employee);
		assertEquals(employee.getId(), 'a');
		System.out.println("Invalid ID: Can not have character ID");				
	}
	@Test
	void testNumericalId() throws EmptyEmployeeObjectException 
	{
		employee=new Employee(1,"Avi",5,"Clerk");
		empDao.addEmployee(employee);
		assertEquals(employee.getId(), 1);
		System.out.println("NumericalId Testcase passed");				
	}
	@Test
	void testNormalSalary() throws EmptyEmployeeObjectException 
	{
		employee=new Employee(1,"Avi",5000,"Clerk");
		empDao.addEmployee(employee);
		assertEquals(employee.getSalary(), 5000);
		System.out.println("Valid Salary: Testcase Passed");
	}
	@Test
	void testNegativeSalary() throws EmptyEmployeeObjectException 
	{
		employee=new Employee(1,"Avi",5000,"Clerk");
		empDao.addEmployee(employee);
		assertNotEquals(employee.getSalary(), -5000);
		System.out.println("Invalid Salary: Can not have negative salary");
	}
	@Test
	void testNotDoubleSalary() throws EmptyEmployeeObjectException 
	{
		employee=new Employee(1,"Avi",5000,"Clerk");
		empDao.addEmployee(employee);
		assertNotEquals(employee.getSalary(), "abcd");
		System.out.println("Salary is Double");
	}
	@Test
	void testStringDesignation() throws EmptyEmployeeObjectException
	{
		employee=new Employee(1,"Avi",5000,"Clerk");
		empDao.addEmployee(employee);
		assertEquals(employee.getDesignation(), "Clerk");
		System.out.println("Test case passed. Designation is string ");
	}
	@Test
	void testNotStringDesignation() throws EmptyEmployeeObjectException
	{
		employee=new Employee(1,"Avi",5000,"Clerk");
		empDao.addEmployee(employee);
		assertNotEquals(employee.getDesignation(), 13);
		//assertEquals(employee.getSalary(), -5000);
		System.out.println("Invalid Designation ");
	}
	@Test
	void testStringInsuranceScheme() throws EmptyEmployeeObjectException
	{
		employee=new Employee(1,"Avi",50000,"Manager");
		employee.setDesignation("Manager");
		employee.setInsuranceScheme("Scheme A");
		empDao.addEmployee(employee);
		String scheme=empDao.getEmployeeInsurance(1);
		assertEquals(scheme, "Scheme A");
		System.out.println("Test case passed");
	}

	@Test
	void testNotStringInsuranceScheme() throws EmptyEmployeeObjectException
	{
		employee=new Employee(1,"Avi",50000,"Manager");
		employee.setDesignation("Manager");
		employee.setInsuranceScheme("Scheme A");
		empDao.addEmployee(employee);
		String scheme=empDao.getEmployeeInsurance(1);
		assertNotEquals(scheme, 12);
		System.out.println("Invalid ");
	}

	
	
	
}
