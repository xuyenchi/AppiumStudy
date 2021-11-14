package javaOOP_lession06;

public class CEO extends Employee {

	public CEO(String id, String name, String address, double workingDay, double rangeSalary, double overtime) {
		super(id, name, address, workingDay, rangeSalary, overtime);

	}

	@Override
	public void showInfo() {
		System.out.println("-----CEO Info-----");
		super.showInfo();
	}

}
