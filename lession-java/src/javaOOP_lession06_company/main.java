package javaOOP_lession06_company;

import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args) {
		// create CEO
		Employee ceo_01 = new CEO("5988686", "Elon Mush", "123 Dien Bien Phu", 24, 1000, 200);
		ceo_01.showInfo();

		// create 2 Manager
		Employee manager_01 = new Manager("8658688", "Henrry Ford", "956 Nguyen Trai", 12, 1600, 10);
		Employee manager_02 = new Manager("8764223", "Bill Gates", "432 Tran Hung Dao", 22, 1600, 15);

		manager_01.showInfo();
		manager_02.showInfo();

		// create 7 normal employee
		Employee employee_01 = new NormalEmployee("3123232", "Mark Zuckerberg", "88 Yesin", 17, 170, 5);
		Employee employee_02 = new NormalEmployee("6456677", "Larry Page", "987 Nguyen Hue", 10, 180, 5);
		Employee employee_03 = new NormalEmployee("7687686", "Tony Heish", "5 Ham Nghi", 17, 170, 5);
		Employee employee_04 = new NormalEmployee("3354545", "Tony Stark", "11 Nguyen Van Cu", 22, 180, 5);
		Employee employee_05 = new NormalEmployee("4646466", "Warren Buffet", "88 Ly Thuong Kiet", 10, 370, 5);
		Employee employee_06 = new NormalEmployee("9999999", "Steve Jobs", "555 Ly Chinh Thang", 27, 160, 8);
		Employee employee_07 = new NormalEmployee("9687888", "Jeff Bazos", "1 Le Van Sy", 19, 190, 5);

		employee_01.showInfo();
		employee_02.showInfo();
		employee_03.showInfo();
		employee_04.showInfo();
		employee_05.showInfo();
		employee_06.showInfo();
		employee_07.showInfo();

		List<Double> salary = new ArrayList<Double>();
		salary.add(employee_01.salaryPerMonthly());
		salary.add(employee_02.salaryPerMonthly());
		salary.add(employee_03.salaryPerMonthly());
		salary.add(employee_04.salaryPerMonthly());
		salary.add(employee_05.salaryPerMonthly());
		salary.add(employee_06.salaryPerMonthly());
		salary.add(employee_07.salaryPerMonthly());

		double totalSalary = total_Salary_NormalEmp(salary) + ceo_01.salaryPerMonthly() + manager_01.salaryPerMonthly()
				+ manager_02.salaryPerMonthly();

		System.out.println("Total salary : " + totalSalary);
	}

	public static double total_Salary_NormalEmp(List<Double> salary) {
		double totalSalary = 0;
		for (double item : salary) {
			totalSalary = totalSalary + item;
		}
		return totalSalary;
	}
}