package javaOOP_lession10;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + "/bookXuyen.txt";
		List<Book> listBooks = new ArrayList<Book>();
		List<Book> readBooks = StoreBook.readBook(filePath);
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
				addBook(listBooks);
				StoreBook.saveBook(listBooks, filePath);
			} else if (myInput == 2) {
				retrieveBook(readBooks);
			} else if (myInput == 0) {
				tryInput = false;
			} else {
				System.out.println("Wrong option!");
			}
		}

	}

	private static void retrieveBook(List<Book> listBook) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Input ISBN you want to retrieve:");
		String ISBN = scanner.nextLine();

		for (Book book : listBook) {
			if (book.getISBN().equals(ISBN)) {
				System.out.println("****Your book****");
				System.out.println("ISBN:" + book.getISBN());
				System.out.println("title:" + book.getTitle());
				System.out.println("author:" + book.getAuthor());
				System.out.println("year:" + book.getYear());
			}
		}

	}

	public static void addBook(List<Book> listBooks) {
		String ISBN, title, author;
		int year;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Input ISBN :");
		ISBN = scanner.nextLine();

		System.out.println("Input Title:");
		title = scanner.nextLine();

		System.out.println("Input Author :");
		author = scanner.nextLine();

		System.out.println("Input Year:");
		year = scanner.nextInt();

		listBooks.add(new Book(ISBN, author, title, year));
	}

}
