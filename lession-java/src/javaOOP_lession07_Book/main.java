package javaOOP_lession07_Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<String> listBook = new ArrayList<String>();
		boolean tryInput = true;
		while (tryInput) {
			System.out.println("=======Book Management=========");
			System.out.println("1. Add book");
			System.out.println("2. Retrieve book");
			System.out.println("0. Exit!");
			System.out.println("Enter your option :");
			int myInput = scanner.nextInt();
			if (myInput == 1) {
				addBook(listBook);
			} else if (myInput == 2) {
				retrieveBook(listBook);
			} else if (myInput == 0) {
				tryInput = false;
			} else {
				System.out.println("Wrong option!");
			}
		}

	}

	private static void retrieveBook(List<String> listBook) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Input ISBN you want to retrieve:");
		String ISBN = scanner.nextLine();

		for (int i = 0; i <= listBook.size()-4; i=i+4) {
			if (listBook.get(i).equals(ISBN)) {
				System.out.println("****Your book****");
				System.out.println("ISBN:" + listBook.get(i));
				System.out.println("title:" + listBook.get(i + 1));
				System.out.println("author:" + listBook.get(i + 2));
				System.out.println("year:" + listBook.get(i + 3));
			}
		}
	}

	public static void addBook(List<String> listBook) {
		String ISBN, title, author, year;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Input ISBN :");
		ISBN = scanner.nextLine();
		listBook.add(ISBN);

		System.out.println("Input Title:");
		title = scanner.nextLine();
		listBook.add(title);

		System.out.println("Input Author :");
		author = scanner.nextLine();
		listBook.add(author);

		System.out.println("Input Year:");
		year = scanner.nextLine();
		listBook.add(year);

	}

}
