package javaOOP_lession06_company;

import java.util.Scanner;

public class Employee {
	private String id;
	private String name;
	private String address;
	private double workingDay;
	private double rangeSalary;
	private double overtime;

	public Employee(String id, String name, String address, double workingDay, double rangeSalary, double overtime) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.workingDay = workingDay;
		this.rangeSalary = rangeSalary;
		this.overtime = overtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(double workingDay) {
		this.workingDay = workingDay;
	}

	public double getRangeSalary() {
		return rangeSalary;
	}

	public void setRangeSalary(double rangeSalary) {
		this.rangeSalary = rangeSalary;
	}

	public double getOvertime() {
		return overtime;
	}

	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}
	
	public double salaryPerMonthly() {
		double salary = 0;
		salary = (workingDay*rangeSalary) + overtime;
		return salary;
	}
	
	public void showInfo() {
		System.out.println("ID:" + id);
		System.out.println("Name:" + name);
		System.out.println("Address:" + address);
		System.out.println("Salary:" + salaryPerMonthly());
		
	}
	
}
