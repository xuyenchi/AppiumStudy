package javaOOP_lession09;

import java.util.Random;

public class Horse extends Animals {

	private double minSpeed = 15;
	private double maxSpeed = 24;

	public Horse(String name, int leg) {
		super(name, leg);
	}

	@Override
	public double speed() {
		Random rd = new Random();
		double speed = minSpeed + (maxSpeed - minSpeed) * rd.nextDouble();
		return speed;
	}

}
