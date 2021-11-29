package javaOOP_lession09;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Horse horse1 = new Horse("horse 1", 4);
		Tiger tiger1 = new Tiger("tiger 1", 4);
		Elephant elephant1 = new Elephant("elephant 1", 4);

		Horse horse2 = new Horse("horse 2", 4);
		Tiger tiger2 = new Tiger("tiger 2", 4);
		Elephant elephant2 = new Elephant("elephant 2", 4);

		System.out.println("Please guess which animal will win :");
		System.out.println("1.Elaphant");
		System.out.println("2.Horse");
		System.out.println("3.Tiger");

		Scanner scanner = new Scanner(System.in);
		int inputGuess = scanner.nextInt();

		Map<String, Double> listAnimal = new HashMap<String, Double>();
		racingAnimal(listAnimal, horse1, tiger1, elephant1, horse2, tiger2, elephant2, inputGuess);
	}

	public static void racingAnimal(Map<String, Double> listAnimal, Horse horse1, Tiger tiger1, Elephant elep1,Horse horse2, Tiger tiger2, Elephant elep2,
			int inputGuess) {
		listAnimal = new HashMap<String, Double>();
		int winHorse = 0;
		int winTiger = 0;
		int winElph = 0;

		for (int i = 0; i < 10; i++) {

			System.out.println("-----------");

			listAnimal.put(horse1.getName(), horse1.speed());
			listAnimal.put(tiger1.getName(), tiger1.speed());
			listAnimal.put(elep1.getName(), elep1.speed());
			double winSpeed = maxSpeed(listAnimal);
//			for (Map.Entry<String, Double> entry : listAnimal.entrySet()) {
//				System.out.print(entry.getKey() + ":" + entry.getValue() + "\n");
//			}

			for (Map.Entry<String, Double> entry : listAnimal.entrySet()) {
				if (entry.getValue() == winSpeed) {
					System.out.println("Round " + (i+1) + ". the winner is :" + entry.getKey() + ", with speed :" + entry.getValue());
					if (entry.getKey().contains("horse"))
						winHorse++;
					if (entry.getKey().contains("elephant"))
						winElph++;
					if (entry.getKey().contains("tiger"))
						winTiger++;
				}
			}

		}
		System.out.println("win horse :" + winHorse + ",win epl :" + winElph + ", win tiger:" + winTiger);
		findWinner(winElph, winHorse, winTiger, inputGuess);
	}

	public static double maxSpeed(Map<String, Double> listAnimal) {
		double maxSpeed = 0;
		for (Map.Entry<String, Double> entry : listAnimal.entrySet()) {

			if (entry.getValue() > maxSpeed) {
				maxSpeed = entry.getValue();
			}
		}
		return maxSpeed;
	}

	public static void findWinner(int winElph, int winHorse, int winTiger, int inputGuess) {
		int[] arrWin = { winElph, winHorse, winTiger };
		if (winElph == max(arrWin) && inputGuess == 1) {
			System.out.println("***The winner is Elephant***");
			System.out.println("You Guessed Correctly!");
		}

		else if (winHorse == max(arrWin) && inputGuess == 2) {
			System.out.println("***The winner is Horse***");
			System.out.println("You Guessed Correctly!");
		}

		else if (winTiger == max(arrWin) && inputGuess == 3) {
			System.out.println("***The winner is Tiger***");
			System.out.println("You Guessed Correctly!");
		} else {
			System.out.println("You Guessed Wrong!");
		}
	}

	public static int max(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (max < a[i])
				max = a[i];
		return max;
	}

}
