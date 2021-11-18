package javabasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lession03 {

	public static void main(String[] args) {
		Lession03 exercise = new Lession03();
		exercise.exercise_01();
		exercise.exercise_02();
		exercise.exercise_03();
		exercise.exercise_04();

	}

	public void exercise_01() {
		System.out.println("-----Exercise 01-----");
		String myHour = "2hrs and 5 minutes";
		String[] newHour = myHour.split("");
		List<String> myArr = new ArrayList<String>();
		for (String item : newHour) {
			if (Character.isDigit(item.charAt(0))) {
				myArr.add(item);
			}
		}

		int countMinutes = (Integer.parseInt(myArr.get(0))) * 60 + (Integer.parseInt(myArr.get(1)));
		System.out.println("Total minutes is :" + countMinutes);
	}

	public void exercise_02() {
		System.out.println("-----Exercise 02-----");
		String myPassword = "password123";
		int tryInput = 0;
		String password;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please input your password:");
			password = scanner.nextLine();
			if (password.equals(myPassword)) {
				System.out.println("Password is correct!");
				//tryInput = 3;
				break;

			} else {
				System.out.println("Password is incorrect!");
				tryInput++;
			}
		} while (tryInput < 3);
	}

	public void exercise_03() {
		System.out.println("-----Exercise 03-----");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input your text :");
		String myStr = scanner.nextLine();
		String[] newStr = myStr.split("");
		String myNumber = "";
		int quantity = 0;
		for (String item : newStr) {
			if (Character.isDigit(item.charAt(0))) {
				myNumber = myNumber.concat(item);
				quantity++;
			}
		}
		if (quantity == 0) {
			System.out.println("Your string doesn't have any numbers!");
		} else
			System.out.println("Your number is:" + myNumber);
	}

	public void exercise_04() {
		System.out.println("-----Exercise 04-----");
		String url = "https://google.com";
		String[] newUrl = url.split("://");
		System.out.println("http method is :" + newUrl[0]);
		System.out.println("domain name is :" + newUrl[1]);

	}
}
