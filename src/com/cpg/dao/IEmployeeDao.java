package com.cpg.dao;

import java.util.List;

import com.cpg.exception.DesignationNullException;
import com.cpg.exception.EmptyEmployeeObjectException;
import com.cpg.exception.IdAlreadyExistsException;
import com.cpg.exception.InsuranceNullException;
import com.cpg.exception.InvalidIdException;
import com.cpg.exception.NoEmployeeInEmployeeListException;
import com.cpg.model.Employee;

public interface IEmployeeDao 
{
	void addEmployee(Employee emp) throws EmptyEmployeeObjectException;
	void addDesignation(long id,String designation) throws DesignationNullException;
	void addInsurance(long id,String insuranceScheme) throws InsuranceNullException;
	String getEmployeeInsurance(long id);
	String getName(long id) throws InvalidIdException;
	List<Employee> getAllEmployee() throws NoEmployeeInEmployeeListException;
	void getDetails(long id) throws InvalidIdException;
	void deleteEmployee(long id) throws InvalidIdException; 
	double getSalary(long id) throws InvalidIdException;
	String getDesignation(long id) throws InvalidIdException;
	public void checkIdExistorNot(long id) throws InvalidIdException; 
	public void checkForExistingId(long id) throws InvalidIdException, IdAlreadyExistsException; 
}
