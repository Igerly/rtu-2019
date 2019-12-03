package rtu_2019;

public class RetroStyle {

	public static User login(long id) { // f: long -> User
		User user = DB.getUserFromDB(id);
		if (user != null) {
			user.loginCount++;
			return DB.saveUserToDB(user);
		} else {
			return null;
		}
	}

	private static void greet(User user) {
		System.out.println("Hello, User " + user.id);
	}
	
	public static void main(String[] args) {
		DB.init();
		User user = login(1);
		if (user != null)
			greet(user);
	}
}