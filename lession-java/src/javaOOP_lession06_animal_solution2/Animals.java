package javaOOP_lession06_animal_solution2;

import java.util.Random;

import sun.security.provider.SecureRandom;

public class Animals {

	
	private int maxSpeed;

	public Animals( int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int run() {
		int speed = 0;
		Random  random = new Random ();
		speed = random.nextInt(this.maxSpeed);
		return speed;
	}

}
