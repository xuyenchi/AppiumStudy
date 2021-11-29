package javaOOP_lession09;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Elephant extends Animals {

	private double minStride = 3;
	private double maxStride = 4;

	public Elephant(String name, int leg) {
		super(name, leg);
	}

	@Override
	public double speed() {
		double speed = 0;
		if (checkLeg(this.leg)) {
			Random rd = new Random();
			speed = (minStride + (maxStride - minStride) * rd.nextDouble()) * 6;
		}

		return speed;
	}

}
