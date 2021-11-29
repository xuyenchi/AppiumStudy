package javaOOP_lession09;

import java.util.Random;

public class Tiger extends Animals {
	private double minWeigh = 250;
	private double maxWeight = 400;

	public Tiger(String name, int leg) {
		super(name, leg);
	}

	@Override
	public double speed() {
		double speed = 0;
		if (checkLeg(this.leg)) {
			Random rd = new Random();
			speed = (minWeigh + (maxWeight - minWeigh) * rd.nextDouble()) * 0.06;
		}

		return speed;
	}

}
