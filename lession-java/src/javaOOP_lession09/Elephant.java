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
		Random rd = new Random();
		double speed = (minStride + (maxStride - minStride) * rd.nextDouble()) * 6;
		return speed;
	}

}
