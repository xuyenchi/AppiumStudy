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
		double speed = 0;
		if (checkLeg(this.leg)) {
			Random rd = new Random();
			speed = minSpeed + (maxSpeed - minSpeed) * rd.nextDouble();
		}

		return speed;
	}
}
