package javaOOP_lession09;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		Horse horse1 = new Horse("horse 1", 4);
		Tiger tiger1 = new Tiger("tiger 1", 4);
		Elephant elephant1 = new Elephant("elephant 1", 4);
//		for (int i = 0; i <=2; i++) {
//			System.out.println("horse 1 : "+ horse1.speed());
//			System.out.println("tiger 1 : "+ tiger1.speed());
//			System.out.println("elep 1 : "+ elephant1.speed());
//			System.out.println("----------");
//		}
		Map<String, Double> listAnimal = new HashMap<String, Double>();
//		for(int i = 0; i< 2; i++) {
//			listAnimal.put(horse1.getName())
//		}
		racingAnimal(listAnimal, horse1, tiger1, elephant1);
	}

	public static void racingAnimal(Map<String, Double> listAnimal, Horse horse1, Tiger tiger1, Elephant elep1) {
		listAnimal = new HashMap<String, Double>();
		int winHorse = 0;
		int winTiger = 0;
		int winElph = 0;

		for (int i = 0; i < 3; i++) {

			System.out.println("-----------");
			double winSpeed = 0;
			listAnimal.put(horse1.getName(), horse1.speed());
			listAnimal.put(tiger1.getName(), tiger1.speed());
			listAnimal.put(elep1.getName(), elep1.speed());

			for (Map.Entry<String, Double> entry : listAnimal.entrySet()) {
				System.out.print(entry.getKey() + ":" + entry.getValue() + "\n");
			}
			for (Map.Entry<String, Double> entry : listAnimal.entrySet()) {
				if (entry.getValue() > winSpeed) {
					winSpeed = entry.getValue();
				}
			}
			for (Map.Entry<String, Double> entry : listAnimal.entrySet()) {
				if (entry.getValue() == winSpeed) {
					System.out.println("the winner is :" + entry.getKey() + ", with speed :" + entry.getValue());
					if (entry.getKey().contains("horse"))
						winHorse++;
					if (entry.getKey().contains("elephant"))
						winElph++;
					if (entry.getKey().contains("tiger"))
						winTiger++;
				}
			}

		}
		System.out.println("win horrse :" + winHorse + ",win epl :" + winElph + "wwin tiger:" + winTiger);
		int[] arrWin = { winElph, winHorse, winTiger };
		if (winElph == max(arrWin))
			System.out.println("The winner is Elephant");
		if (winHorse == max(arrWin))
			System.out.println("The winner is Horse");
		if (winTiger == max(arrWin))
			System.out.println("The winner isin Tiger");
	}

	public static int max(int [] a)
	{
	    int max = a[0];
	    for (int i = 1; i < a.length; i++)
	        if (max < a[i])
	            max = a[i];
	    return max;
	}

}
