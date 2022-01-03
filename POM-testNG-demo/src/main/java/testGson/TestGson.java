package testGson;

import com.google.gson.Gson;

import utils.data.DataObjectBuilder;

public class TestGson {

	public static void main(String[] args) {
//		String jsonObject ="[\n"
//				+ "	{\n"
//				+ "		\"username\":\"Jennie\",\n"
//				+ "		\"password\":\"123456789\",\n"
//				+ "		\"info\":{\n"
//				+ "			\"age\":26\n"
//				+ "		}\n"
//				+ "		\n"
//				+ "	},\n"
//				+ "	{\n"
//				+ "		\"username\":\"Lisa\",\n"
//				+ "		\"password\":\"99999999\",\n"
//				+ "		\"info\":{\n"
//				+ "			\"age\":42\n"
//				+ "		}\n"
//				+ "		\n"
//				+ "	}\n"
//				+ "]";
//		Gson gson = new Gson();
//		// convert Json to Class
////		Login login = gson.fromJson(jsonObject, Login.class);
////		System.out.println(login);
////
////		// convert object to json
////		System.out.println("object to json:" + gson.toJson(login));
//		Login[] login = gson.fromJson(jsonObject, Login[].class);
//		for(Login loginItem : login) {
//			System.out.println(loginItem);
//		}
//
		Login[] login = DataObjectBuilder.builderDataOject("/data/Login.json", Login[].class);
		for (Login loginItem : login) {
			System.out.println(loginItem);
		}
	}
}
