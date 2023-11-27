package udemyCertificateOracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

 class Employee {
	private String name;
	private String department;
	private int salary;
	public Employee(String name, String department, int salary) {
		this.name=name;
		this.department=department;
		this.salary=salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}

class TestEmployee {
	void printEmployee (Employee e) {
		System.out.println(e.getName()+" "+e.getDepartment()+" "+e.getSalary());
	}
	
	void filteringWorkers (ArrayList<Employee> arraylist, Predicate<Employee> predicate) {
		for (Employee e : arraylist) {
			if (predicate.test(e)) {
				printEmployee(e);
			}
		}
	}

}

public class Lambda {
	public static void main(String[] args) {
		Employee Katya = new Employee("Katya123", "Ecorfewfgw", 500);
		
		ArrayList<Employee> list = new ArrayList<Employee>(Arrays.asList(new Employee("Vanya", "parasha", 10),
											new Employee("Artem", "boss", 99999),
											new Employee("Dima", "futbol", 50)));
		
		TestEmployee testEmployee = new TestEmployee();
		testEmployee.printEmployee(Katya);
		System.out.println("----------");
		testEmployee.filteringWorkers(list, (Employee e) -> e.getSalary()>10);
		list.stream()
		.filter((Employee e) -> e.getSalary()>10)
//		.collect(Collectors.toList())
		.map(Employee::getName)
		.forEach(e->System.out.println(e));
		
		
//		list.stream().map((Employee e) -> e.getSalary()>10)
//		.collect(Collectors.toList())
//		.forEach(e->System.out.println(e));
	}
}
