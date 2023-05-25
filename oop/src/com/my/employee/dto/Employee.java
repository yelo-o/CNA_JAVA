package com.my.employee.dto;
import com.my.dto.Person;

public class Employee extends Person{
	private String no;
	private int salary;
	public Employee() {
	}
	
	public Employee(String no, String name) {
		super();
		this.no = no;
		setName(name);
	}

	public Employee(String no, String name, int salary) {
		super();
		this.no = no;
		setName(name);
		this.salary = salary;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
