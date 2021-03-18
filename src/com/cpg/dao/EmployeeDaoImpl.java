package com.cpg.dao;
import com.cpg.exception.*;
import com.cpg.model.Employee;
import java.util.*;
public class EmployeeDaoImpl implements IEmployeeDao
{
	static Employee employee=new Employee();
	static HashMap<Long, Employee> employeeList;
	public EmployeeDaoImpl()
	{
		if(null==employeeList)
		employeeList=new HashMap<>();
		
	}
	
	//adding an employee in employeeList
	public void addEmployee(Employee emp) throws EmptyEmployeeObjectException
	{
		if(emp==null)
			throw new EmptyEmployeeObjectException("The employee object is empty.");
			else
		employeeList.put(emp.getId(), emp);
	}
	
	//adding a designation to employee
	public void addDesignation(long id,String designation) throws DesignationNullException
	{
			if(designation.isEmpty())
		{
				throw new DesignationNullException("Designation can not be null");
			
		}
		else 
			 employeeList.get(id).setDesignation(designation);
		
	}
	
	//adding insurance to employee in employeelist
	public void addInsurance(long id,String insuranceScheme) throws InsuranceNullException
	{
			if(insuranceScheme.isEmpty())
		{
				throw new InsuranceNullException("Designation can not be null");
			
		}
		else 
			 employeeList.get(id).setInsuranceScheme(insuranceScheme);
	}
	
	//returns employee insurance scheme from employeeList
	public String getEmployeeInsurance(long id)
	{
		return employeeList.get(id).getInsuranceScheme();
	}
	
	//returns employee name from employeeList
	public String getName(long id) throws InvalidIdException
	{
		String name=employeeList.get(id).getName();
		return name;
	}
	
	//return all employees from employeeList
	public List<Employee> getAllEmployee() throws NoEmployeeInEmployeeListException
	{
		ArrayList<Employee> al=new ArrayList<>();
		if(employeeList.isEmpty())
			throw new NoEmployeeInEmployeeListException("No employee in employee list");
		else
		{
		Set<Long> list=employeeList.keySet();
		for(Long x:list)
		{
			al.add(employeeList.get(x));
		}
		}
		return al;
	}
	//return an employee's salary
	public double getSalary(long id) throws InvalidIdException
	{
		
		return employeeList.get(id).getSalary();
	}
	
	//return an emplyess's designation
	public String getDesignation(long id) throws InvalidIdException
	{
		return  employeeList.get(id).getDesignation();
	}
	
	//return an employee's details
	public void getDetails(long id) throws InvalidIdException 
	{
		if(employeeList.containsKey(id))
		{
			System.out.println("The details of all the employees are:");
		System.out.println("Name:"+employeeList.get(id).getName());
		System.out.println("Id:"+employeeList.get(id).getId());
		if(employeeList.get(id).getDesignation()!=null)
		System.out.println("Designation:"+employeeList.get(id).getDesignation());
		System.out.println("Salary:"+employeeList.get(id).getSalary());
		if(employeeList.get(id).getInsuranceScheme()!=null)
		System.out.println("Insurance scheme:"+employeeList.get(id).getInsuranceScheme());
	}
		else 
			throw new InvalidIdException("Invalid ID Entered");
	}
	
	//To delete an employee from employeeList
	
	@Override
	public void deleteEmployee(long id) throws InvalidIdException 
	{
		if(employeeList.containsKey(id))
		{
			employeeList.remove(id);
		}
		else 
			throw new InvalidIdException("The entered id does not exist");
		
	}
	public void checkIdExistorNot(long id) throws InvalidIdException 
	{
		if(employeeList.containsKey(id)==false)
			throw new InvalidIdException("The id does not exist"); 
	}

	@Override
	public void checkForExistingId(long id) throws IdAlreadyExistsException 
	{
		// TODO Auto-generated method stub
		if(employeeList.containsKey(id))
			throw new IdAlreadyExistsException("The given Employee ID already exists.");
	}
	
}
