package testGson;

public class Login {

	private String username;
	private String password;
	private Info info;

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsernam() {
		return username;
	}

	public void setUsernam(String usernam) {
		this.username = usernam;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {

		return "{username: " + this.username + ", pass:" + this.password + ", age :"+ this.info.age;
	}

	private static class Info {
		private int age;
	}

}
