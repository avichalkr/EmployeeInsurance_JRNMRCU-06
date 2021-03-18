package com.cpg.service;

import com.cpg.exception.DesignationNullException;
import com.cpg.exception.EmptyEmployeeObjectException;
import com.cpg.exception.IdAlreadyExistsException;
import com.cpg.exception.InsuranceNullException;
import com.cpg.exception.InvalidIdException;
import com.cpg.exception.NoEmployeeInEmployeeListException;
import com.cpg.model.Employee;

public interface IEmployeeService 
{

	public void selectInsurance(long id) throws InsuranceNullException, InvalidIdException;
	public void giveDesignation(long id) throws InvalidIdException, DesignationNullException ;
	public void add(Employee emp) throws EmptyEmployeeObjectException, InvalidIdException, IdAlreadyExistsException ;
	public void getDetails(long id) throws InvalidIdException;
	public void delete(long id) throws InvalidIdException ;
	public void getEmployee(Employee emp) throws InvalidIdException;
	public void getAllEmployee() throws NoEmployeeInEmployeeListException;
}
