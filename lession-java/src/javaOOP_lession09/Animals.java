package javaOOP_lession09;

public abstract class Animals {

	private String name;
	private int leg;

	public Animals(String name, int leg) {
		this.name = name;
		this.leg = leg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLeg() {
		return leg;
	}

	public void setLeg(int leg) {
		this.leg = leg;
	}

	public abstract double speed();

}
