package javaOOP_lession07_animal_builder;

import java.util.Random;

import sun.security.provider.SecureRandom;

public class Animals {

	private String name;
	private int maxSpeed;
	private Animals(Builder builder) {
		this.name = builder.name;
		this.maxSpeed = builder.maxSpeed;
	}

	public Animals(String name, int maxSpeed) {
		this.name = name;
		this.maxSpeed = maxSpeed;
	}
	
	public String getName() {
		return name;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}


	public int run() {
		Random random = new Random();
		int speed = random.nextInt(this.maxSpeed);
		return speed;
	}

	public static class Builder {
		private String name;
		private int maxSpeed;
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		public Builder withSpeed(int speed) {
			this.maxSpeed = speed;
			return this;
		}
		public Animals build() {
			return new Animals(this);
		}
	}

}
