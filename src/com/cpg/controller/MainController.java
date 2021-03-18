package com.cpg.controller;

import com.cpg.model.Employee;
import com.cpg.exception.DesignationNullException;
import com.cpg.exception.EmptyEmployeeObjectException;
import com.cpg.exception.IdAlreadyExistsException;
import com.cpg.exception.InsuranceNullException;
import com.cpg.exception.InvalidIdException;
import com.cpg.exception.InvalidInputException;
import com.cpg.exception.NoEmployeeInEmployeeListException;
import com.cpg.service.EmployeeServiceImpl;
import com.cpg.service.IEmployeeService;
import com.cpg.utility.Utility;

public class MainController 
{
	private static IEmployeeService employeeService=new EmployeeServiceImpl();

	public static void main(String args[]) throws InvalidInputException, InvalidIdException, DesignationNullException, NoEmployeeInEmployeeListException, InsuranceNullException, EmptyEmployeeObjectException, IdAlreadyExistsException
	{
		runApplication();
	}
	static void runApplication() throws InvalidInputException, InvalidIdException, DesignationNullException, NoEmployeeInEmployeeListException, InsuranceNullException, EmptyEmployeeObjectException, IdAlreadyExistsException
	{
		System.out.println("Enter\n"
				+ "1. To add employee\n"
				+ "2. To select insurance\n"
				+ "3. To delete employee\n"
				+ "4. To give designation on basis of salary\n"
				+ "5. To display allthe employes\n"
				+ "6. To exit");
		boolean flag=true;
		long id;
		while(flag)
		{
			System.out.println("Enter the choice:");
			int choice=Utility.scanner.nextInt();
			if(choice>6 || choice<1)
				throw new InvalidInputException("Out of range input. Please input a number between 1-6");
			else
			{
			switch(choice)
			{
			case 1:System.out.println("Enter id of employee");
			id=Utility.scanner.nextLong();
			System.out.println("Enter name of employee");
			String name=Utility.scanner.next();
			System.out.println("Enter salary of employee");
			double salary=Utility.scanner.nextDouble();
			Employee e=new com.cpg.model.Employee();
			e.setId(id);
			e.setName(name);
			e.setSalary(salary);
			employeeService.add(e);
			System.out.println("Employee added successfully");
			break;
			case 2: System.out.println("Enter employee id to select insurance");
			id=Utility.scanner.nextLong();
			employeeService.selectInsurance(id);
			employeeService.getDetails(id);
			System.out.println("Employe given insurance successfully");
			break;
			case 3:System.out.println("Enter employee id to delete");
			id=Utility.scanner.nextLong();
			employeeService.delete(id);
			System.out.println("Employee deleted successfully");
			break;
			case 4:
				System.out.println("Enter employee id to allot desigantion");
				id=Utility.scanner.nextLong();
				employeeService.giveDesignation(id);
				employeeService.getDetails(id);
				System.out.println("Employee given designation successfuly");
				break;
			case 5:
				employeeService.getAllEmployee();	
				break;
			case 6: flag=false;
			break;
			
			}
			}//end of else-block
		}
	}

}
