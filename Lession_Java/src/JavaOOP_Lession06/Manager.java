package JavaOOP_Lession06;

public class Manager extends Employee {

	public Manager(String id, String name, String address, double workingDay, double rangeSalary, double overtime) {
		super(id, name, address, workingDay, rangeSalary, overtime);

	}

	@Override
	public void showInfo() {
		System.out.println("-----Manager Info-----");
		super.showInfo();
	}

}
