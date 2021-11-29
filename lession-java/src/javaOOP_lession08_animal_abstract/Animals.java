package javaOOP_lession08_animal_abstract;

import java.util.Random;

import sun.security.provider.SecureRandom;

public class Animals {

	private String name;
	private int speed;

	public Animals(String name, int maxSpeed) {
		Random  random = new Random ();
		this.name = name;
		this.speed = random.nextInt(maxSpeed);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int maxSpeed) {
		this.speed = maxSpeed;
	}

//	public int run() {
//		Random  random = new Random ();
//		int speed = random.nextInt(this.maxSpeed);
//		return speed;
//	}

}
