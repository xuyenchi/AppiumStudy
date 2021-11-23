package javaOOP_lession07_animal_builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sun.security.ec.ECDSAOperations.Seed;

public class TestAnimal {

	public static void main(String[] args) {
		Animals.Builder builder = new Animals.Builder();
		Animals horse = builder.withName("horse 01").withSpeed(75).build();
		Animals tiger = builder.withName("tiger 01").withSpeed(100).build();
		Animals dog = builder.withName("dog 01").withSpeed(65).build();

		Map<String, Integer> speed = new HashMap<String, Integer>();
		speed.put(horse.getName(), horse.run());
		speed.put(tiger.getName(), tiger.run());
		speed.put(dog.getName(), dog.run());
		Iterator<Map.Entry<String, Integer>> iterator = speed.entrySet().iterator();
		System.out.println("Các entry có trong hashMap là: ");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		run_Competition(speed, horse, tiger, dog);
	}

	public static void run_Competition(Map<String, Integer> speed, Animals horse, Animals tiger, Animals dog) {
		int maxSpeed = 0;
		String winnerName = "";
		for (Map.Entry<String, Integer> entry : speed.entrySet()) {
			if (entry.getValue() >= maxSpeed) {
				maxSpeed = entry.getValue();
				winnerName = winnerName.replace(winnerName, entry.getKey());

			}

		}

		System.out.println("winner is :" + winnerName + " with speed :" + maxSpeed);

	}

}
