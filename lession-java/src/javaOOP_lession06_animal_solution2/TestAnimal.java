package javaOOP_lession06_animal_solution2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sun.security.ec.ECDSAOperations.Seed;

public class TestAnimal {

	public static void main(String[] args) {
		Horse horse = new Horse(75);
		Tiger tiger = new Tiger(100);
		Dog dog = new Dog(60);

		int speedHorse = horse.run();
		int speedTiger = tiger.run();
		int speedDog = dog.run();

		List<Integer> listSpeed = new ArrayList<Integer>();
		listSpeed.add(speedHorse);
		listSpeed.add(speedTiger);
		listSpeed.add(speedDog);
		racing_Competition(listSpeed, horse, tiger, dog);

	}

	public static void racing_Competition(List<Integer> listSpeed, Horse horse, Tiger tiger, Dog dog) {
		int maxSpeed = 0;
		String winnerName = "";
		for (int value : listSpeed) {
			if (value > maxSpeed)
				maxSpeed = value;
		}

		if (maxSpeed == listSpeed.get(0)) {
			System.out.println("winner is :" + horse.getClass().getSimpleName() + " with speed :" + maxSpeed);

		}
		if (maxSpeed == listSpeed.get(1)) {
			System.out.println("winner is :" + tiger.getClass().getSimpleName() + " with speed :" + maxSpeed);

		}
		if (maxSpeed == listSpeed.get(2)) {
			System.out.println("winner is :" + dog.getClass().getSimpleName() + " with speed :" + maxSpeed);
		}

	}

}
