package javaOOP_lession09;

import java.util.Random;

public class Tiger extends Animals {
	private double minWeigh = 250;
	private double maxWeight = 40;

	public Tiger(String name, int leg) {
		super(name, leg);
	}

	@Override
	public double speed() {
		Random rd = new Random();
		double speed = (minWeigh + (maxWeight - minWeigh) * rd.nextDouble()) * 0.06;
		return speed;
	}

}
