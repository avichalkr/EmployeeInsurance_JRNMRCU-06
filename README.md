# EmployeeInsurance_JRNMRCU-06
Employee Insurance Implementation
-----------------------------------------------------------------------------------------------------------
Refer the case study and create an application for that requirement by creating packages and classes as given below:
Case Study:
Employee Medical Insurance Scheme:

By default, all employees in an organization will be assigned with a medical insurance scheme based on the salary range and designation of the employee. 

Refer the below given table to find the eligible insurance scheme specific to an employee.
Salary
Designation
Insurance scheme
>5000 and < 20000
System Associate
Scheme C
>=20000 and <40000
Programmer
Scheme B
>=40000
Manager
Scheme A
<5000 
Clerk
No Scheme
com.cg.eis.bean
    In this package, create “Employee” class with different attributes such as id, name, salary, designation, insuranceScheme.
com.cg.eis.service
This package will contain code for services offered in Employee Insurance System. The service class will have one EmployeeService Interface and its corresponding implementation class.
com.cg.eis.pl
This package will contain code for getting input from user, produce expected output to the user and invoke services offered by the system. 
On the basis of above case study implement a class to accept multiple employee details and store all employee objects in a Hashmap. The functionalities need to be implemented are as follows:

Add employee details to Hashmap.
Accept insurance scheme from user and display employee details based on Insurance scheme.
Delete an employee details from map.
Build Expectation
