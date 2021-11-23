package javaOOP_lession06_animal_solution1;

import java.util.Random;

import sun.security.provider.SecureRandom;

public class Animals {

	private String name;
	private int maxSpeed;

	public Animals(String name, int maxSpeed) {
		this.name = name;
		this.maxSpeed = maxSpeed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int run() {
		Random  random = new Random ();
		int speed = random.nextInt(this.maxSpeed);
		return speed;
	}

}
