package utils.data;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class DataObjectBuilder {

	public static <T> T builderDataOject(String filePath, Class<T> classData) {
		String absoluteFilePath = System.getProperty("user.dir").concat(filePath);
		try (Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));) {
			Gson gson = new Gson();
			return gson.fromJson(reader, classData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
