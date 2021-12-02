package javaOOP_lession10;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class StoreBook {

	public static void saveBook(List<Book> listBooks, String filePath) {

		try (FileOutputStream fos = new FileOutputStream(filePath);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw);

		) {
			for (Book book : listBooks) {
				String data = book.getISBN() + ";" + book.getTitle() + ";" + book.getAuthor() + ";" + book.getYear();
				bw.write(data);
				bw.newLine();
				System.out.print("save success");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static List<Book> readBook(String filePath) {
		List<Book> listBooks = new ArrayList<Book>();
		try (

				FileInputStream fis = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);

		) {
			String dataLine = br.readLine();
			while (dataLine != null) {
				String[] dataBook = dataLine.split(";");
				String ISBN = dataBook[0];
				String title = dataBook[1];
				String author = dataBook[2];
				int year = Integer.parseInt(dataBook[3]);
				listBooks.add(new Book(ISBN, title, author, year));
				dataLine= br.readLine();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listBooks;
	}

}
