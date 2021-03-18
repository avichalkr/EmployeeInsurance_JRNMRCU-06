package com.cpg.service;

import com.cpg.dao.EmployeeDaoImpl;
import com.cpg.dao.IEmployeeDao;
import com.cpg.exception.DesignationNullException;
import com.cpg.exception.EmptyEmployeeObjectException;
import com.cpg.exception.IdAlreadyExistsException;
import com.cpg.exception.InsuranceNullException;
import com.cpg.exception.InvalidIdException;
import com.cpg.exception.NoEmployeeInEmployeeListException;
import com.cpg.model.Employee;

import java.util.List;
public class EmployeeServiceImpl implements  IEmployeeService
{
	private static IEmployeeDao empDao;
	public EmployeeServiceImpl()
	{
		if(empDao==null)
			empDao=new EmployeeDaoImpl();
	}
	//To set insurance scheme
	public void selectInsurance(long id) throws InsuranceNullException, InvalidIdException
	{
		empDao.checkIdExistorNot(id);
		double sal=empDao.getSalary(id);
		String designation=empDao.getDesignation(id);
		String schemeAlloted="";
		if((sal>5000 && sal < 20000) && (designation.equalsIgnoreCase("System Associate")))
			schemeAlloted="Scheme C";
		else if((sal>=20000 && sal<40000) && (designation.equalsIgnoreCase("Programmer")))
			schemeAlloted="Scheme B";
		else if((sal>=40000) && (designation.equalsIgnoreCase("Manager")))
			schemeAlloted="Scheme A";
		else
			schemeAlloted="No scheme";
		empDao.addInsurance(id, schemeAlloted);	
		
	}
	
	//To set Designation
	public void giveDesignation(long id) throws InvalidIdException, DesignationNullException 
	{
		empDao.checkIdExistorNot(id);
		double sal=empDao.getSalary(id);
		String designation="";
		if(sal>5000 && sal < 20000) 
				designation="System Associate";
		else if(sal>=20000 && sal<40000) 
				designation="Programmer";
		else if(sal>=40000)
			designation="Manager";
		else
			designation="Clerk";
		empDao.addDesignation(id, designation);
	}
	//To add employee
	public void add(Employee emp) throws EmptyEmployeeObjectException, InvalidIdException, IdAlreadyExistsException 
	{
		empDao.checkForExistingId(emp.getId());
		empDao.addEmployee(emp);
	}
	
	//To display details
	public void getDetails(long id) throws InvalidIdException
	{
		empDao.checkIdExistorNot(id);
		empDao.getDetails(id);
	}
	//To delete employee
	public void delete(long id) throws InvalidIdException 
	{
		empDao.checkIdExistorNot(id);
		empDao.deleteEmployee(id);
	}
	
	//TO get an employee
	public void getEmployee(Employee emp) throws InvalidIdException
	{
		
		empDao.getDetails(emp.getId());
	}
	//to get all employees
	public void getAllEmployee() throws NoEmployeeInEmployeeListException 
	{	
		List<Employee> l=empDao.getAllEmployee();
		for(Employee x:l)
		{
			System.out.println("Name:"+ x.getName());
			System.out.println("ID:"+ x.getId());
			System.out.println("Salary:"+ x.getSalary());
			if(x.getDesignation()!=null)
			System.out.println("Designation:"+ x.getDesignation());
			if(x.getInsuranceScheme()!=null)
			System.out.println("Insurance:"+ x.getInsuranceScheme());
		}
		}
	}