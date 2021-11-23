package javaOOP_lession06_animal_solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sun.security.ec.ECDSAOperations.Seed;

public class TestAnimal {

	public static void main(String[] args) {
		Horse horse = new Horse("horse 01", 75);
		Tiger tiger = new Tiger("tiger 01", 100);
		Dog dog = new Dog("dog 01", 60);

		Map<String, Integer> speed = new HashMap<String, Integer>();
		speed.put(horse.getName(), horse.run());
		speed.put(tiger.getName(), tiger.run());
		speed.put(dog.getName(), dog.run());

		run_Competition(speed, horse, tiger, dog);
	}

	public static void run_Competition(Map<String, Integer> speed, Horse horse, Tiger tiger, Dog dog) {
		int maxSpeed = 0;
		String winnerName = "";
		// chạy vòng lặp đầu tiên tìm ptu lớn nhất
		for (Map.Entry<String, Integer> entry : speed.entrySet()) {
			if (entry.getValue() > maxSpeed) {
				maxSpeed = entry.getValue();
			}
		}
		// chạy lần 2 để tìm ptư bằng maxSpeed, vì có thể có nhiều con vật có tốc độ = maxSpeed
		for (Map.Entry<String, Integer> entry : speed.entrySet()) {
			if (entry.getValue() == maxSpeed) {
				maxSpeed = entry.getValue();
				winnerName = winnerName.replace(winnerName, entry.getKey());
				System.out.println(
						"winner is :" + winnerObject(winnerName, horse, tiger, dog) + " with speed :" + maxSpeed);

			}
		}

	}

	public static String winnerObject(String nameAnimals, Horse horse, Tiger tiger, Dog dog) {
		String objectName = "";
		if (nameAnimals.contains("horse")) {
			objectName = horse.getClass().getSimpleName();
		}
		if (nameAnimals.contains("tiger")) {
			objectName = tiger.getClass().getSimpleName();
		}
		if (nameAnimals.contains("dog")) {
			objectName = dog.getClass().getSimpleName();
		}
		return objectName;
	}
}
